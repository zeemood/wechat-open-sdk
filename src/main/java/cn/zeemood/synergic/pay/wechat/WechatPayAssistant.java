package cn.zeemood.synergic.pay.wechat;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zeemood.synergic.pay.wechat.utils.WechatPayConst;
import com.alipay.api.internal.util.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URIBuilder;
import org.dom4j.Document;

import com.alibaba.fastjson.JSON;

import cn.zeemood.synergic.common.HttpClientUtils;
import cn.zeemood.synergic.common.SnGenerator;
import cn.zeemood.synergic.common.XMLUtils;
import cn.zeemood.synergic.pay.wechat.domain.WechatPayInfo;
import cn.zeemood.synergic.pay.wechat.domain.WechatPayRet;
import cn.zeemood.synergic.pay.wechat.domain.WechatPreOrderInfo;
import cn.zeemood.synergic.pay.wechat.domain.WechatRefundInfo;
import cn.zeemood.synergic.pay.wechat.domain.WechatRefundRet;
import cn.zeemood.synergic.pay.wechat.utils.WeChatPayErrorUtil;
import cn.zeemood.synergic.pay.wechat.utils.WechatPayConfigurations;

/**
 * 微信支付操作类
 *
 * @author zhang.shushan
 * @date 2018年1月19日
 */
public class WechatPayAssistant {

    /**
     * 解析回调请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static WechatPayRet parseRequest(HttpServletRequest request) throws Exception {
        String xml = XMLUtils.readXmlFromRequest(request);
        return (WechatPayRet) XMLUtils.convertXml2Bean(xml, WechatPayRet.class);
    }

    /**
     * 应答微信回调
     *
     * @param response
     * @throws Exception
     */
    public static void echo(HttpServletResponse response) throws Exception {
        response.setContentType("application/xml");
        ServletOutputStream os = response.getOutputStream();
        os.print(echo());
    }

    /**
     * 异步回调应答
     *
     * @return
     * @throws Exception
     */
    public static String echo() throws Exception {
        return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }

    /**
     * 异步回调应答
     *
     * @return
     * @throws Exception
     */
    @Deprecated
    public static String responseTo() throws Exception {
        return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }

    /**
     * 微信移动支付退款
     *
     * @param refundInfo
     * @return
     * @throws Exception
     */
    public static WechatRefundRet refund(WechatRefundInfo refundInfo) throws Exception {

        refundInfo.setAppid(WechatPayConfigurations.getAppId());
        refundInfo.setMch_id(WechatPayConfigurations.getMchId());
        refundInfo.setNonce_str(SnGenerator.randomMix(32));
        refundInfo.setSign(generateSign(refundInfo));
        TreeMap<String, Object> map = getSignMap(refundInfo, WechatRefundInfo.class);
        Document doc = XMLUtils.convertMap2Xml(map);
        URI uri = new URIBuilder().setScheme("https").setHost("api.mch.weixin.qq.com").setPath("/secapi/pay/refund")
                .build();
        String xml = HttpClientUtils.connectWithXMLAndSSLByPost(uri, doc,
                WechatPayConfigurations.getRefundCertificatePath(),
                WechatPayConfigurations.getRefundCertificatePassword());
        WechatRefundRet obj = (WechatRefundRet) XMLUtils.convertXml2Bean(xml, WechatRefundRet.class);
        return obj;
    }

    /**
     * 微信预支付订单
     *
     * @param payInfo
     * @return
     * @throws Exception
     */
    public static WechatPreOrderInfo preOrder(WechatPayInfo payInfo) throws Exception {

        if(payInfo.getTrade_type().equals(WechatPayConst.TRADE_TYPE_OFFICIAL_ACCOUNT)&& StringUtils.isEmpty(payInfo.getOpenid())){
            throw new RuntimeException("公众号支付openid不能为空，请填入正确的openid");
        }

        payInfo.setAppid(WechatPayConfigurations.getAppId());
        payInfo.setMch_id(WechatPayConfigurations.getMchId());

        payInfo.setNonce_str(SnGenerator.randomMix(32).toUpperCase());
        payInfo.setSign(generateSign(payInfo));
        Document doc = XMLUtils.convertMap2Xml(getSignMap(payInfo, WechatPayInfo.class));
        URI uri = new URIBuilder().setScheme("https").setHost("api.mch.weixin.qq.com").setPath("/pay/unifiedorder")
                .build();
        String xml = HttpClientUtils.connectWithXMLByPost(uri, doc);
        WechatPreOrderInfo info = (WechatPreOrderInfo) XMLUtils.convertXml2Bean(xml, WechatPreOrderInfo.class);
        if (!info.isContact()) {
            String msg = info.getReturn_code() + ":" + info.getReturn_msg();
            msg = new String(msg.getBytes("iso-8859-1"), "utf-8");
            throw new RuntimeException(msg);
        }
        if (!info.isSuccess()) {
            String msg = info.getResult_code() + ":" + WeChatPayErrorUtil.getErrorMsg(info.getErr_code());
            throw new RuntimeException(msg);
        }
        return info;
    }

    /**
     * 设置签名
     *
     * @param obj
     * @return
     * @throws Exception
     */
    private static String generateSign(Object obj) throws Exception {
        TreeMap<String, Object> map = getSignMap(obj, obj.getClass());
        return signMap(map);
    }

    /**
     *
     * @param map
     * @return
     * @throws Exception
     */
    private static String signMap(TreeMap<String,Object> map) throws Exception{
        Set<String> keys = map.keySet();
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append("=").append(map.get(key)).append("&");
        }
        sb.append("key").append("=").append(WechatPayConfigurations.getPayKey());
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }

    /**
     * 获取按顺序整理好的非空值字段
     *
     * @param obj
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private static TreeMap<String, Object> getSignMap(Object obj, Class<?> clz) throws Exception {
        if (obj == null) {
            throw new RuntimeException("支付对象不能为空");
        }
        Field[] fields = clz.getDeclaredFields();

        // 使用treeMap将字段按要求排序
        TreeMap<String, Object> map = new TreeMap<>();
        for (Field field : fields) {
            map.put(field.getName(), clz.getMethod("get" + uperFirst(field.getName())).invoke(obj));
        }

        // 使用fastjson过滤掉null的字段，爱死fastjson了
        String json = JSON.toJSONString(map);
        map = JSON.parseObject(json, TreeMap.class);
        return map;
    }

    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
    private static String uperFirst(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * APP支付二次加签
     * @param preOrderInfo
     * @return
     * @throws Exception
     */
    public static Map<String,Object> sign4App(WechatPreOrderInfo preOrderInfo)throws Exception{
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("appid", preOrderInfo.getAppid());
        map.put("partnerid", preOrderInfo.getMch_id());
        map.put("prepayid", preOrderInfo.getPrepay_id());
        map.put("package", preOrderInfo.getPackage());
        map.put("noncestr", SnGenerator.randomMix(32));
        map.put("timestamp", preOrderInfo.getTimestamp());
        map.put("sign", signMap(map));
        return map;
    }
    
    /**
     * 微信内H5支付二次加签(吐槽微信，APP加签字段全部小写，这里加签又驼峰，炒鸡不规范啊)
     * @param preOrderInfo
     * @return
     * @throws Exception
     */
    public static Map<String,Object> sign4WxH5(WechatPreOrderInfo preOrderInfo)throws Exception{
    	TreeMap<String, Object> map = new TreeMap<>();
        map.put("appId", preOrderInfo.getAppid());
        map.put("timeStamp", preOrderInfo.getTimestamp());
        map.put("package", "prepay_id="+preOrderInfo.getPrepay_id());
        map.put("nonceStr", SnGenerator.randomMix(32));
        map.put("signType", "MD5");
        map.put("paySign", generateSign(map));
    	return map;
    }
    
}
