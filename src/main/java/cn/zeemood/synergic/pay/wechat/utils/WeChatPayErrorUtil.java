package cn.zeemood.synergic.pay.wechat.utils;

import java.util.HashMap;
import java.util.Map;

import cn.zeemood.synergic.pay.wechat.domain.WechatPayError;

public class WeChatPayErrorUtil {

	private static Map<String, WechatPayError> errs = new HashMap<>();

	static {
		errs.put("NOAUTH", WechatPayError.builder().err_code_des("商户无此接口权限").err_cause("商户未开通此接口权限")
				.err_resolve("请商户前往申请此接口权限").build());
		errs.put("NOTENOUGH", WechatPayError.builder().err_code_des("余额不足").err_cause("用户帐号余额不足")
				.err_resolve("用户帐号余额不足，请用户充值或更换支付卡后再支付").build());
		errs.put("ORDERPAID", WechatPayError.builder().err_code_des("商户订单已支付").err_cause("商户订单已支付，无需重复操作")
				.err_resolve("商户订单已支付，无需更多操作").build());
		errs.put("ORDERCLOSED", WechatPayError.builder().err_code_des("订单已关闭").err_cause("当前订单已关闭，无法支付")
				.err_resolve("当前订单已关闭，请重新下单").build());
		errs.put("SYSTEMERROR",
				WechatPayError.builder().err_code_des("系统错误").err_cause("系统超时").err_resolve("系统异常，请用相同参数重新调用").build());
		errs.put("APPID_NOT_EXIST", WechatPayError.builder().err_code_des("APPID不存在").err_cause("参数中缺少APPID")
				.err_resolve("请检查APPID是否正确").build());
		errs.put("MCHID_NOT_EXIST", WechatPayError.builder().err_code_des("MCHID不存在").err_cause("参数中缺少MCHID")
				.err_resolve("请检查MCHID是否正确").build());
		errs.put("APPID_MCHID_NOT_MATCH", WechatPayError.builder().err_code_des("appid和mch_id不匹配")
				.err_cause("appid和mch_id不匹配").err_resolve("请确认appid和mch_id是否匹配").build());
		errs.put("LACK_PARAMS",
				WechatPayError.builder().err_code_des("缺少参数").err_cause("缺少必要的请求参数").err_resolve("请检查参数是否齐全").build());
		errs.put("OUT_TRADE_NO_USED", WechatPayError.builder().err_code_des("商户订单号重复 ").err_cause("同一笔交易不能多次提交")
				.err_resolve("请核实商户订单号是否重复提交").build());
		errs.put("SIGNERROR", WechatPayError.builder().err_code_des("签名错误").err_cause("参数签名结果不正确")
				.err_resolve("请核实商户订单号是否重复提交").build());
		errs.put("XML_FORMAT_ERROR", WechatPayError.builder().err_code_des("XML格式错误").err_cause("XML格式错误")
				.err_resolve("请检查XML参数格式是否正确").build());
		errs.put("REQUIRE_POST_METHOD", WechatPayError.builder().err_code_des("请使用post方法").err_cause("未使用post传递参数")
				.err_resolve("请检查请求参数是否通过post方法提交").build());
		errs.put("POST_DATA_EMPTY", WechatPayError.builder().err_code_des("post数据为空").err_cause("post数据不能为空")
				.err_resolve("请检查post数据是否为空").build());
		errs.put("NOT_UTF8", WechatPayError.builder().err_code_des("编码格式错误").err_cause("未使用指定编码格式")
				.err_resolve("请使用NOT_UTF8编码格式").build());

	}
	
	public static String getErrorMsg(String result_code) {
		// TODO Auto-generated method stub
		return errs.get(result_code).getErr_cause()+":"+errs.get(result_code).getErr_resolve();
	}
}
