package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 支付宝社交查询群信息
 *
 * @author auto create
 * @since 1.0, 2017-08-15 15:05:42
 */
public class AlipaySocialBaseChatGinfoQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4561851341957722152L;

	/**
	 * 群id
	 */
	@ApiField("group_id")
	private String groupId;

	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
