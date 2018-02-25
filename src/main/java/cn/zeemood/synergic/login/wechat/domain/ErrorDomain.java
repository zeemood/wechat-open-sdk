package cn.zeemood.synergic.login.wechat.domain;

/**
 * 错误信息类
 * 
 * @author zhang.shushan
 * @date 2018年1月18日
 */
public class ErrorDomain {

	// 错误码
	private Integer errcode;
	// 错误信息
	private String errmsg;
	
	public Integer getErrcode() {
		return errcode;
	}
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
