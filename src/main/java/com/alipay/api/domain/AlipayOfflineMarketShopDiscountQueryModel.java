package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 基于门店id的优惠查询服务
 *
 * @author auto create
 * @since 1.0, 2017-12-19 18:45:25
 */
public class AlipayOfflineMarketShopDiscountQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4341121246883667546L;

	/**
	 * 查询类型 目前取值：MERCHANT(商户活动)，  如果不传递该参数或者指定参数值，出参只返回item_list，discount_list， 反之返回camp_num,camp_list
	 */
	@ApiField("query_type")
	private String queryType;

	/**
	 * 门店id，注意:必须传递isv授权商户下的门店，否则无权限查询
	 */
	@ApiField("shop_id")
	private String shopId;

	public String getQueryType() {
		return this.queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
