package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 发票抬头
 *
 * @author auto create
 * @since 1.0, 2017-03-15 15:25:34
 */
public class InvoiceTitleModel extends AlipayObject {

	private static final long serialVersionUID = 6296254166869366231L;

	/**
	 * 是否默认
可选值：
false：非默认
true：默认抬头
	 */
	@ApiField("is_default")
	private Boolean isDefault;

	/**
	 * 支付宝用户登录名（脱敏后登录名）
该字段输出接口只限
alipay.ebpp.invoice.title.dynamic.get
	 */
	@ApiField("logon_id")
	private String logonId;

	/**
	 * 开户行账号
	 */
	@ApiField("open_bank_account")
	private String openBankAccount;

	/**
	 * 开户行
	 */
	@ApiField("open_bank_name")
	private String openBankName;

	/**
	 * 纳税人识别号
	 */
	@ApiField("tax_register_no")
	private String taxRegisterNo;

	/**
	 * 发票抬头名称
	 */
	@ApiField("title_name")
	private String titleName;

	/**
	 * 发票类型
可选值：
PERSONAL（个人抬头）
CORPORATION（公司抬头）
	 */
	@ApiField("title_type")
	private String titleType;

	/**
	 * 地址
	 */
	@ApiField("user_address")
	private String userAddress;

	/**
	 * 用户邮箱
	 */
	@ApiField("user_email")
	private String userEmail;

	/**
	 * 支付宝用户id
说明：动态码获取抬头时接口（alipay.ebpp.invoice.title.dynamic.get ）用户id返回结果为加密后密文
其他情况用户id来源于用户授权
	 */
	@ApiField("user_id")
	private String userId;

	/**
	 * 联系电话，支持手机和固话两种格式
	 */
	@ApiField("user_mobile")
	private String userMobile;

	public Boolean getIsDefault() {
		return this.isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getLogonId() {
		return this.logonId;
	}
	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}

	public String getOpenBankAccount() {
		return this.openBankAccount;
	}
	public void setOpenBankAccount(String openBankAccount) {
		this.openBankAccount = openBankAccount;
	}

	public String getOpenBankName() {
		return this.openBankName;
	}
	public void setOpenBankName(String openBankName) {
		this.openBankName = openBankName;
	}

	public String getTaxRegisterNo() {
		return this.taxRegisterNo;
	}
	public void setTaxRegisterNo(String taxRegisterNo) {
		this.taxRegisterNo = taxRegisterNo;
	}

	public String getTitleName() {
		return this.titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getTitleType() {
		return this.titleType;
	}
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getUserAddress() {
		return this.userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return this.userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserMobile() {
		return this.userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

}
