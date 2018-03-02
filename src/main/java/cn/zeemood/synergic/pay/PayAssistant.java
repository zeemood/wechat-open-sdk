package cn.zeemood.synergic.pay;

import cn.zeemood.synergic.pay.alipay.AlipayAssistant;
import cn.zeemood.synergic.pay.wechat.WechatPayAssistant;
import cn.zeemood.synergic.pay.wechat.domain.WechatPayInfo;
import cn.zeemood.synergic.pay.wechat.domain.WechatPreOrderInfo;
import cn.zeemood.synergic.pay.wechat.domain.WechatRefundInfo;
import cn.zeemood.synergic.pay.wechat.domain.WechatRefundRet;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.response.AlipayTradeRefundResponse;

/**
 * 支付助手工具类,使用方法重载的思路合并支付宝和微信支付类
 * @author zhang.shushan
 */
public class PayAssistant {

    /**
     * 微信统一下单工具类
     * @param wechatPayInfo
     * @return
     * @throws Exception
     */
    public static WechatPreOrderInfo preOrder(WechatPayInfo wechatPayInfo) throws Exception{
         return WechatPayAssistant.preOrder(wechatPayInfo);
    }

    /**
     * 支付宝APP支付
     * @param model
     * @param suffix
     * @return
     * @throws Exception
     */
    public static String preOrder(AlipayTradeAppPayModel model, String suffix) throws Exception{
        return AlipayAssistant.preOrder4App(model,suffix);
    }

    /**
     * 支付宝手机网页支付
     * @param model
     * @param return_url
     * @param notify_url
     * @return
     * @throws Exception
     */
    public static String preOrder(AlipayTradeWapPayModel model,String return_url,String notify_url) throws Exception{
        return AlipayAssistant.preOrder4Wap(model,return_url,notify_url);
    }

    /**
     * 支付宝网页支付
     * @param model
     * @param return_url
     * @param notify_url
     * @return
     * @throws Exception
     */
    public static String preOrder(AlipayTradePagePayModel model,String return_url,String notify_url) throws Exception{
        return AlipayAssistant.preOrder(model,return_url,notify_url);
    }

    /**
     * 微信退款
     * @param wechatRefundInfo
     * @return
     * @throws Exception
     */
    public static WechatRefundRet refund(WechatRefundInfo wechatRefundInfo) throws Exception{
        return WechatPayAssistant.refund(wechatRefundInfo);
    }

    /**
     * 支付宝退款
     * @param model
     * @return
     * @throws Exception
     */
    public static AlipayTradeRefundResponse refund(AlipayTradeRefundModel model) throws Exception{
        return AlipayAssistant.refund(model);
    }

    /**
     * 微信应答信息
     * @return
     * @throws Exception
     */
    public static String echoWechat() throws Exception{
        return WechatPayAssistant.echo();
    }

    /**
     * 支付宝应答信息
     * @return
     * @throws Exception
     */
    public static String echoAlipay() throws Exception{
        return AlipayAssistant.echo();
    }

}
