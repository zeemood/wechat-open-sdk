package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 支付宝社交查询加入的群列表
 *
 * @author auto create
 * @since 1.0, 2017-08-15 15:05:48
 */
public class AlipaySocialBaseChatGroupsQueryModel extends AlipayObject {

	private static final long serialVersionUID = 6427186149416446166L;

	/**
	 * 上次接口返回的key，初始传0
	 */
	@ApiField("last_key")
	private Long lastKey;

	public Long getLastKey() {
		return this.lastKey;
	}
	public void setLastKey(Long lastKey) {
		this.lastKey = lastKey;
	}

}
