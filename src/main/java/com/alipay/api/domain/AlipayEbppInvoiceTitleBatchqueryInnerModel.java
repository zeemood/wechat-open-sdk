package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 获取指定用户所有的有效抬头列表（集团内部接口）
 *
 * @author auto create
 * @since 1.0, 2016-12-22 21:53:37
 */
public class AlipayEbppInvoiceTitleBatchqueryInnerModel extends AlipayObject {

	private static final long serialVersionUID = 8535798369369111265L;

	/**
	 * 抬头所属支付宝用户id
	 */
	@ApiField("user_id")
	private String userId;

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
