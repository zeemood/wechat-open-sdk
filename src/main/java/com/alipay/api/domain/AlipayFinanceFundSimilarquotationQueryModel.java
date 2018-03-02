package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 查询基金同类收益率数据
 *
 * @author auto create
 * @since 1.0, 2017-09-21 16:08:13
 */
public class AlipayFinanceFundSimilarquotationQueryModel extends AlipayObject {

	private static final long serialVersionUID = 2391214274749452447L;

	/**
	 * 基金代码
	 */
	@ApiField("fund_code")
	private String fundCode;

	public String getFundCode() {
		return this.fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

}
