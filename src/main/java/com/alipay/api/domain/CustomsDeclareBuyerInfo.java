package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 报关订购人信息，即用户留在商户处的身份信息。可用于与支付单的身份信息作比对。
 *
 * @author auto create
 * @since 1.0, 2016-11-09 19:11:51
 */
public class CustomsDeclareBuyerInfo extends AlipayObject {

	private static final long serialVersionUID = 5359439992373339819L;

	/**
	 * 订购人身份证号。即订购人留在商户处的身份证信息
	 */
	@ApiField("buyer_cert_no")
	private String buyerCertNo;

	/**
	 * 订购人姓名。即订购人留在商户处的姓名信息
	 */
	@ApiField("buyer_name")
	private String buyerName;

	public String getBuyerCertNo() {
		return this.buyerCertNo;
	}
	public void setBuyerCertNo(String buyerCertNo) {
		this.buyerCertNo = buyerCertNo;
	}

	public String getBuyerName() {
		return this.buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

}
