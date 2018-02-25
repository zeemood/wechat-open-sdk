package cn.zeemood.synergic.login.wechat.domain;

/**
 * 获取access_token用的code实体类
 * @author zhang.shushan
 * @date 2018年1月18日
 */
public class Code4AccessToken extends ErrorDomain{

	private String code;
	private String state;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
