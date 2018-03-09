package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 对账配置查询接口
 *
 * @author auto create
 * @since 1.0, 2017-06-22 16:17:25
 */
public class AlipayEbppProdmodeReconconfQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4419639991292769453L;

	/**
	 * 缴费业务类型
	 */
	@ApiField("biz_type")
	private String bizType;

	/**
	 * 销账机构编码
	 */
	@ApiField("chargeoff_code")
	private String chargeoffCode;

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getChargeoffCode() {
		return this.chargeoffCode;
	}
	public void setChargeoffCode(String chargeoffCode) {
		this.chargeoffCode = chargeoffCode;
	}

}
