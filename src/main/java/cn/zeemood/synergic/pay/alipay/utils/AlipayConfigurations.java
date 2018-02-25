package cn.zeemood.synergic.pay.alipay.utils;

import java.io.InputStream;
import java.util.Properties;

public class AlipayConfigurations {

	private static Properties props;
	static{
		try(InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("payConfigure.properties");){
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 支付宝支付公钥
	 * @return
	 */
	public static String getPublicKey(){
		return props.getProperty("alipay.public_key");
	}
	
	/**
	 * 支付宝支付私钥
	 * @return
	 */
	public static String getPrivateKey(){
		return props.getProperty("alipay.private_key");
	}
	
	/**
	 * 获取应用id
	 * @return
	 */
	public static String getAppid(){
		return props.getProperty("alipay.app_id");
	}

	/**
	 * 获取支付环境
	 * @return
	 */
	public static boolean getPayEnviroment() {
		String p = props.getProperty("pay.enviroment");
		if(p==null||"".equals(p)){
			p="dev";
		}
		return !p.equals("dev");
	}

	/**
	 * 获取异步通知的回调地址
	 * @param suffix
	 * @return
	 */
	public static String getNotifyUrl(String suffix) {
		if(!getPayEnviroment()){
			suffix+="_test";
		}
		return props.getProperty("alipay.pay.notify_url."+suffix);
	}

	/**
	 * 获取同步通知的回调地址
	 * @param suffix
	 * @return
	 */
	public static String getReturnUrl(String suffix) {
		if(!getPayEnviroment()){
			suffix+="_test";
		}
		return props.getProperty("alipay.pay.return_url."+suffix);
	}
}
