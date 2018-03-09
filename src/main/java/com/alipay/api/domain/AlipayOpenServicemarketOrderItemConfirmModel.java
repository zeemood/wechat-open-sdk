package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 服务商代商家确认完成
 *
 * @author auto create
 * @since 1.0, 2016-08-25 11:11:32
 */
public class AlipayOpenServicemarketOrderItemConfirmModel extends AlipayObject {

	private static final long serialVersionUID = 4652754311533718125L;

	/**
	 * 商品订单ID
	 */
	@ApiField("commodity_order_id")
	private String commodityOrderId;

	/**
	 * 商家订购服务选择的某一门店的ID
	 */
	@ApiField("shop_id")
	private String shopId;

	public String getCommodityOrderId() {
		return this.commodityOrderId;
	}
	public void setCommodityOrderId(String commodityOrderId) {
		this.commodityOrderId = commodityOrderId;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
