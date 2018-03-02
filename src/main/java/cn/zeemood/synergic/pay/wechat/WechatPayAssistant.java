package cn.zeemood.synergic.pay.wechat;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.client.utils.URIBuilder;
import org.dom4j.Document;

import com.alibaba.fastjson.JSON;

import cn.zeemood.synergic.common.HttpClientUtils;
import cn.zeemood.synergic.common.MD5Utils;
import cn.zeemood.synergic.common.SnGenerator;
import cn.zeemood.synergic.common.XMLUtils;
import cn.zeemood.synergic.pay.wechat.domain.WechatPayInfo;
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
	 * 异步回调应答
	 * @return
	 * @throws Exception
	 */
	public static String echo() throws Exception{
		return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}

	/**
	 * 异步回调应答
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public static String responseTo() throws Exception {
		return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}

	/**
	 * 微信退款
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
		Set<String> keys = map.keySet();
		StringBuilder sb = new StringBuilder();
		for (String key : keys) {
			sb.append(key).append("=").append(map.get(key)).append("&");
		}
		sb.append("key").append("=").append(WechatPayConfigurations.getPayKey());
		return MD5Utils.MD5Encode(sb.toString(), true);
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

		// 使用fastjson过滤掉null的字段
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
}
