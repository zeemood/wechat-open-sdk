package cn.zeemood.synergic.pay.alipay.utils;

import java.math.BigDecimal;

import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.StringUtils;

/**
 * 业务参数填写工具类
 * @author zhang.shushan
 * @date 2018年1月24日
 */
public class AlipayModelUtils {
	
	/**
	 * 手机网页支付
	 * @param outTradeNo
	 * @param subject
	 * @param body
	 * @param totalAmount
	 * @return
	 * @throws Exception
	 */
	public static AlipayTradeWapPayModel getWapPayModel(String outTradeNo,String subject,String body,BigDecimal totalAmount) throws Exception{
		
		AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
		model.setOutTradeNo(outTradeNo);
		model.setSubject(subject);
		model.setBody(body);
		if(AlipayConfigurations.getPayEnviroment()){
			model.setTotalAmount(totalAmount.toString());
		}else{
			model.setTotalAmount("0.01");
		}
		model.setProductCode("QUICK_WAP_WAY");
		
		return null;
	}
	
	/**
	 * 退款必填参数
	 * @param outTradeNo 商户订单号
	 * @param refundAmount 退款金额
	 * @param refundReason 退款原因
	 * @return
	 * @throws Exception
	 */
	public static AlipayTradeRefundModel getRefundModel(String outTradeNo,BigDecimal refundAmount,String refundReason) throws Exception{
		AlipayTradeRefundModel model = new AlipayTradeRefundModel();
		model.setOutTradeNo(outTradeNo);
		model.setRefundAmount(refundAmount.toString());
		model.setRefundReason(refundReason);
		return model;
	}
	
	/**
	 * 填写电脑支付的必要参数
	 * @param outTradeNo 商户订单号
	 * @param totalAmount 总价
	 * @param subject 订单标题
	 * @param body 订单描述
	 * @param passbackParams 回调回传参数
	 * @return
	 * @throws Exception
	 */
	public static AlipayTradePagePayModel getPcPayModel(
			String outTradeNo,
			BigDecimal totalAmount,
			String subject,
			String body,
			String passbackParams) throws Exception{
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
		
		model.setOutTradeNo(outTradeNo);
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		if(AlipayConfigurations.getPayEnviroment()){
			model.setTotalAmount(totalAmount.setScale(2).toString());
		}else{
			model.setTotalAmount("0.01");
		}
		model.setSubject(subject);
		model.setBody(body);
		if(StringUtils.areNotEmpty(passbackParams)){
			model.setPassbackParams(passbackParams);
		}
		return model;
	}

	/**
	 * 设置必要的业务参数
	 * @param body 商品描述
	 * @param subject 商品的标题/交易标题/订单标题/订单关键字等
	 * @param out_trade_no 商户订单号
	 * @param timeout_express 有效时间，单位为分钟
	 * @param total_account 价格，传入带两位小数的数字 字符串，测试环境时为固定值0.01
	 * @return
	 * @throws Exception
	 */
	public static AlipayTradeAppPayModel getAppPayModel(String body, String subject, String out_trade_no,
			int timeout_express, BigDecimal total_account) throws Exception {
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody(body);
		model.setSubject(subject);
		model.setOutTradeNo(out_trade_no);
		model.setTimeoutExpress(timeout_express+"m");
		if(!AlipayConfigurations.getPayEnviroment()){
			model.setTotalAmount("0.01");
		}else{
			model.setTotalAmount(total_account.toString());
		}
		model.setProductCode("QUICK_MSECURITY_PAY");
		return model;
	}

}
