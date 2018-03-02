package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 开启带商户签约、创建应用事务
 *
 * @author auto create
 * @since 1.0, 2017-12-28 15:38:03
 */
public class AlipayOpenAgentCreateModel extends AlipayObject {

	private static final long serialVersionUID = 1374746474759843899L;

	/**
	 * isv代操作的商户账号，可以是支付宝账号，也可以是pid（2088开头）
	 */
	@ApiField("account")
	private String account;

	/**
	 * 商户联系人信息，包含联系人名称、手机、邮箱信息。联系人信息将用于接受签约后的重要通知，如确认协议、到期提醒等。
	 */
	@ApiField("contact_info")
	private ContactModel contactInfo;

	public String getAccount() {
		return this.account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public ContactModel getContactInfo() {
		return this.contactInfo;
	}
	public void setContactInfo(ContactModel contactInfo) {
		this.contactInfo = contactInfo;
	}

}
