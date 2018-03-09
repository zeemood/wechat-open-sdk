package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 外部记录
 *
 * @author auto create
 * @since 1.0, 2017-12-22 16:04:33
 */
public class OuterMemberInfo extends AlipayObject {

	private static final long serialVersionUID = 3287294343543643327L;

	/**
	 * 商户记录的用户信息
	 */
	@ApiField("user_info")
	private String userInfo;

	public String getUserInfo() {
		return this.userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

}
