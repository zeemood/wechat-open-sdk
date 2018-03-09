package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 查询机构英文名称
 *
 * @author auto create
 * @since 1.0, 2017-06-22 16:17:10
 */
public class AlipayEbppProdmodeInstshortnameQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4624984658618167359L;

	/**
	 * 出账机构中文名称
	 */
	@ApiField("chargeinst_cn_name")
	private String chargeinstCnName;

	public String getChargeinstCnName() {
		return this.chargeinstCnName;
	}
	public void setChargeinstCnName(String chargeinstCnName) {
		this.chargeinstCnName = chargeinstCnName;
	}

}
