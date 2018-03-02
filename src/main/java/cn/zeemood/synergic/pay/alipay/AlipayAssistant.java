package cn.zeemood.synergic.pay.alipay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;

import cn.zeemood.synergic.pay.alipay.utils.AlipayConfigurations;

/**
 * 支付宝支付工具类
 *
 * @author zhang.shushan
 */
public class AlipayAssistant {

    /**
     * 是否是关闭订单，如果是关闭订单，注意处理业务，如下发新的商户订单号
     *
     * @param out_trade_no
     * @return true-是 false-不是
     * @throws Exception
     */
    public static boolean isClosedOrder(String out_trade_no) throws Exception {
        String status = orderStatusQuery(out_trade_no);
        return !status.equals("WAIT_BUYER_PAY");
    }

    /**
     * 订单状态查询
     *
     * @param out_trade_no
     * @return
     * @throws Exception
     */
    public static String orderStatusQuery(String out_trade_no) throws Exception {

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigurations.GATE_URL, // 支付地址
                AlipayConfigurations.getAppid(), // 应用id
                AlipayConfigurations.getPrivateKey(), // 私钥
                "json", // 固定值json，参数类型，
                AlipayConstants.CHARSET_UTF8, // 编码方式
                AlipayConfigurations.getPublicKey(), // 公钥
                "RSA2");
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo(out_trade_no);
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        String tradeStatus = response.getTradeStatus();
        return tradeStatus;

    }

    /**
     * 手机网页支付
     * @param model 支付信息模型
     * @param return_url 回跳地址
     * @param notify_url 异步回调地址
     * @return
     * @throws Exception
     */
    public static String preOrder(AlipayTradeWapPayModel model, String return_url, String notify_url) throws Exception{
        return preOrder4Wap(model,return_url,notify_url);
    }

    /**
     * 手机网页支付
     *
     * @param model
     * @param return_url
     * @param notify_url
     * @return 返回的是一个网页
     * @throws Exception
     */
    public static String preOrder4Wap(AlipayTradeWapPayModel model, String return_url, String notify_url) throws Exception {
        String html = "";
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigurations.GATE_URL, // 支付地址
                AlipayConfigurations.getAppid(), // 应用id
                AlipayConfigurations.getPrivateKey(), // 私钥
                "json", // 固定值json，参数类型，
                AlipayConstants.CHARSET_UTF8, // 编码方式
                AlipayConfigurations.getPublicKey(), // 公钥
                "RSA2");
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();

        if (return_url != null && !"".equals(return_url)) {
            request.setReturnUrl(return_url);
        }
        request.setNotifyUrl(notify_url);
        request.setBizModel(model);
        AlipayTradeWapPayResponse response = alipayClient.pageExecute(request);
        html = response.getBody();
        return html;
    }

    /**
     * 退款接口
     *
     * @param model
     * @return
     * @throws Exception
     */
    public static AlipayTradeRefundResponse refund(AlipayTradeRefundModel model) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigurations.GATE_URL, // 支付地址
                AlipayConfigurations.getAppid(), // 应用id
                AlipayConfigurations.getPrivateKey(), // 私钥
                "json", // 固定值json，参数类型，
                AlipayConstants.CHARSET_UTF8, // 编码方式
                AlipayConfigurations.getPublicKey(), // 公钥
                "RSA2");
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizModel(model);
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if (!response.isSuccess()) {
            throw new RuntimeException("调用失败");
        }
        return response;
    }

    /**
     * 网页支付
     * @param model 支付信息数据模型
     * @param return_url 回跳地址
     * @param notify_url 异步回调地址
     * @return 返回的是一个网页
     * @throws Exception
     */
    public static String preOrder(AlipayTradePagePayModel model, String return_url, String notify_url) throws Exception{
        return preOrder4Web(model,return_url,notify_url);
    }

    /**
     * 网页支付
     *
     * @param model
     * @param return_url
     * @param notify_url
     * @return
     * @throws Exception
     */
    public static String preOrder4Web(AlipayTradePagePayModel model, String return_url, String notify_url) throws Exception {
        String html = "";
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigurations.GATE_URL,
                AlipayConfigurations.getAppid(), AlipayConfigurations.getPrivateKey(), "json",
                AlipayConstants.CHARSET_UTF8, AlipayConfigurations.getPublicKey(), "RSA2"); // 获得初始化的AlipayClient
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        if (return_url != null && !"".equals(return_url)) {
            request.setReturnUrl(return_url);
        }
        request.setNotifyUrl(notify_url);
        request.setBizModel(model);
        html = alipayClient.pageExecute(request).getBody();
        return html;
    }

    /**
     * 支付宝APP预支付
     * @param model
     * @param suffix
     * @return
     * @throws Exception
     */
    public static String preOrder(AlipayTradeAppPayModel model, String suffix) throws Exception{
        return preOrder4App(model,suffix);
    }

    /**
     * 支付宝生成APP订单
     *
     * @param model
     * @return
     * @throws Exception
     */
    public static String preOrder4App(AlipayTradeAppPayModel model, String suffix) throws Exception {
        // 实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigurations.GATE_URL, // 支付地址
                AlipayConfigurations.getAppid(), // 应用id
                AlipayConfigurations.getPrivateKey(), // 私钥
                "json", // 固定值json，参数类型，
                AlipayConstants.CHARSET_UTF8, // 编码方式
                AlipayConfigurations.getPublicKey(), // 公钥
                "RSA2");
        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        request.setBizModel(model);
        if (suffix == null || "".equals(suffix)) {
            throw new RuntimeException("回调地址后缀不能为空");
        }
        request.setNotifyUrl(AlipayConfigurations.getNotifyUrl(suffix));
        try {
            // 这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            return response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 将Map转换成对象
     *
     * @param map
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Object convertMap2Bean(Map<String, String> map, Class<?> clazz) throws Exception {
        Map<String, Object> objMap = new TreeMap<>();
        //预处理map，将里面的json字符串字段转换成对象
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String str = map.get(key);
            try {
                //如果是JSON字符串，则转换成对象，再添加到objMap中
                objMap.put(key, JSON.parse(str));
            } catch (JSONException e) {
                //如果不是JSON字符串，则直接添加到objMap中
                objMap.put(key, str);
            } catch (Exception e) {
                //其余错误抛出
                e.printStackTrace();
            }
        }
        Object obj = JSON.parseObject(JSON.toJSONString(objMap), clazz);
        return obj;
    }

    /**
     * 验签并返回参数
     *
     * @param requestParamterMap
     * @param enc
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, String> getParamsMap(Map requestParamterMap, boolean enc) throws Exception {
        Map<String, String> params = new HashMap<>();

        for (Iterator iter = requestParamterMap.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParamterMap.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            if (enc) {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            }
            params.put(name, valueStr);
        }

        // 切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        // boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String
        // publicKey, String charset, String sign_type)
        boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfigurations.getPublicKey(), "UTF-8", "RSA2");
        if (!flag) {
            throw new RuntimeException("验签失败");
        }
        return params;
    }

    /**
     * 异步回调返回参数
     * @return
     */
    public static String echo(){
        return "success";
    }

}
