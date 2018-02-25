package cn.zeemood.synergic.pay.wechat.utils;

/**
 * 微信支付常量词典
 * 
 * @author zhang.shushan
 * @date 2018年1月19日
 */
public class WechatPayConst {

	// 签名类型md5
	public static final String SIGN_TYPE_MD5 = "MD5";
	// 签名类型sha256
	public static final String SIGN_TYPE_SHA256 = "HMAC-SHA256";

	// 支付类型：公众号支付
	public static final String TRADE_TYPE_OFFICIAL_ACCOUNT = "JSAPI";
	// 支付类型：扫码支付
	public static final String TRADE_TYPE_SWEEP_CODE = "NATIVE";
	// 支付类型：APP
	public static final String TRADE_TYPE_APP = "APP";
}
