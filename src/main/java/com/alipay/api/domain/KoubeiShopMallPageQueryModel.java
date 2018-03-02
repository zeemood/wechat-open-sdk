package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 商圈地址查询接口
 *
 * @author auto create
 * @since 1.0, 2017-03-31 14:01:13
 */
public class KoubeiShopMallPageQueryModel extends AlipayObject {

	private static final long serialVersionUID = 7188294691391196736L;

	/**
	 * 商圈id
	 */
	@ApiField("mall_id")
	private String mallId;

	public String getMallId() {
		return this.mallId;
	}
	public void setMallId(String mallId) {
		this.mallId = mallId;
	}

}
