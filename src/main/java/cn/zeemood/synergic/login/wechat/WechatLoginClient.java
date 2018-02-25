package cn.zeemood.synergic.login.wechat;

import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Properties;

import org.apache.http.client.utils.URIBuilder;

import com.alibaba.fastjson.JSON;

import cn.zeemood.synergic.common.HttpClientUtils;
import cn.zeemood.synergic.login.wechat.domain.AccessToken4UserInfo;
import cn.zeemood.synergic.login.wechat.domain.Code4AccessToken;
import cn.zeemood.synergic.login.wechat.domain.ErrorDomain;
import cn.zeemood.synergic.login.wechat.domain.WechatUserInfo;

/**
 * 微信三方登陆工具类
 * @author zhang.shushan
 * @date 2018年1月18日
 */
public class WechatLoginClient {

	//pc端认证界面
	private final static String AUTH_URL_PC="https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";
	//替换
	private static final String RPLC="%s";
	private static Properties props;
	
	static{
		try(InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/synergicLogin.properties")) {
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 电脑端微信登录的链接
	 * @param notisfy_url 回调地址
	 * @param state 携带参数
	 * @return
	 * @throws Exception
	 */
	public static String getPcAuthUrl(String notisfy_url,String state) throws Exception{
		String url=AUTH_URL_PC;
		try {
			if(notisfy_url!=null&&!"".equals(notisfy_url)){
				url=url.replaceFirst(RPLC, getPcAppid()).replaceFirst(RPLC, URLEncoder.encode(getPcRedirectUrl(), "UTF-8"));
			}else{
				url=url.replaceFirst(RPLC, getPcAppid()).replaceFirst(RPLC, URLEncoder.encode(notisfy_url,"UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return url;
	}
	
	/**
	 * 通过Code获取用户信息
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static WechatUserInfo getUserInfoByCode(Code4AccessToken code) throws Exception{
		AccessToken4UserInfo accessToken = getAccessToken(code);
		return getUserInfo(accessToken);
	}
	
	/**
	 * 获取access_token
	 * @param code
	 * @return
	 * @throws Exception
	 */
	protected static AccessToken4UserInfo getAccessToken(Code4AccessToken code) throws Exception{
		URI url = new URIBuilder().setScheme("https")
				.setHost("open.weixin.qq.com")
				.setPath("/sns/oauth2/access_token")
				.setParameter("appid", getPcAppid())
				.setParameter("secret", getPcSecrect())
				.setParameter("code", code.getCode())
				.setParameter("grant_type","authorization_code")
				.build();
		String json = HttpClientUtils.connectByGet(url);
		AccessToken4UserInfo obj = JSON.parseObject(json, AccessToken4UserInfo.class);
		isSuccess(obj);
		return obj;
	}
	
	
	/**
	 * 获取授权用户信息
	 * @param token
	 * @return
	 * @throws Exception
	 */
	protected static WechatUserInfo getUserInfo(AccessToken4UserInfo token) throws Exception{
		URI url = new URIBuilder().setScheme("https")
				.setHost("open.weixin.qq.com")
				.setPath("/sns/userinfo")
				.setParameter("access_token", token.getAccess_token())
				.setParameter("openid", token.getOpernid())
				.build();
		String json = HttpClientUtils.connectByGet(url);
		WechatUserInfo obj = JSON.parseObject(json, WechatUserInfo.class);
		isSuccess(obj);
		return obj;
	}
	
	
	/**
	 * 网页应用的回调地址
	 * @return
	 */
	protected static String getPcRedirectUrl(){
		return props.getProperty("wechat.pc.redirect_url");
	}
	
	/**
	 * 网页应用的密钥
	 * @return
	 */
	protected static String getPcSecrect(){
		return props.getProperty("wechat.pc.secrect");
	}
	
	/**
	 * 网页应用的appid
	 * @return
	 */
	protected static String getPcAppid(){
		return props.getProperty("wechat.pc.appid");
	}
	
	/**
	 * 是否成功
	 * @param obj
	 * @throws Exception
	 */
	private static void isSuccess(ErrorDomain obj) throws Exception{
		if(obj.getErrcode()!=null){
			throw new RuntimeException(obj.getErrcode()+">>"+obj.getErrmsg());
		}
	}
}
