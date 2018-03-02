package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 联行信息查询接口
 *
 * @author auto create
 * @since 1.0, 2017-06-22 16:17:15
 */
public class AlipayEbppProdmodeUnionbankQueryModel extends AlipayObject {

	private static final long serialVersionUID = 3639336761173122258L;

	/**
	 * 银联编号
	 */
	@ApiField("bank_code")
	private String bankCode;

	public String getBankCode() {
		return this.bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

}
