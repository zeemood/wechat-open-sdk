package cn.zeemood.synergic.pay.wechat.utils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 微信配置文件，此类可修改
 * 
 * @author zhang.shushan
 * @date 2018年1月19日
 */
public class WechatPayConfigurations {

	private static Properties props;

	static {
		try (InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("payConfigure.properties")) {
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据后缀获取回调地址
	 * 
	 * @param suffix
	 * @return
	 */
	public static String getNotifyUrl(String suffix) {
		String notify_url = "";
		suffix = "wechat.pay.notify_url." + suffix;
		if (!getPayEnvironment()) {
			notify_url = props.getProperty(suffix+"_test");
		}else{
			notify_url = props.getProperty(suffix);
		}
		if (notify_url == null || "".equals(notify_url)) {
			throw new RuntimeException("回调地址不存在");
		}
		return notify_url;
	}

	/**
	 * 获取应用所在的环境类型
	 * 
	 * @return
	 */
	public static boolean getPayEnvironment() {
		String p = props.getProperty("pay.environment");
		if (p == null || "".equals(p)) {
			p = "dev";
		}
		return !p.equals("dev");
	}

	/**
	 * 获取支付密钥
	 * 
	 * @return
	 */
	public static String getPayKey() {
		return props.getProperty("wechat.pay.key");
	}

	/**
	 * 应用id
	 * 
	 * @return
	 */
	public static String getAppId() {
		return props.getProperty("wechat.appid");
	}

	/**
	 * 商户号
	 * 
	 * @return
	 */
	public static String getMchId() {
		return props.getProperty("wechat.mch_id");
	}

	/**
	 * 应用名称
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String getAppName() throws UnsupportedEncodingException {
		return new String(props.getProperty("wechat.app.name").getBytes("ISO8859-1"),"UTF-8");
	}

	/**
	 * 获取微信退款证书所在路径
	 * 
	 * @return
	 */
	public static String getRefundCertificatePath() {
		// TODO Auto-generated method stub
		return props.getProperty("wechat.pay.refund.certificate.path");
	}

	/**
	 * 移动应用的退款密码
	 *
	 * @return
	 */
	public static String getRefundCertificatePassword() {
		// TODO Auto-generated method stub
		return props.getProperty("wechat.pay.refund.certificate.password");
	}

}
