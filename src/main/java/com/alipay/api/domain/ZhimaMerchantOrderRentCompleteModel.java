package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 信用借还订单归还
 *
 * @author auto create
 * @since 1.0, 2017-10-31 16:01:03
 */
public class ZhimaMerchantOrderRentCompleteModel extends AlipayObject {

	private static final long serialVersionUID = 3345818455175823953L;

	/**
	 * 信用借还订单号
	 */
	@ApiField("order_no")
	private String orderNo;

	/**
	 * 支付金额
	 */
	@ApiField("pay_amount")
	private String payAmount;

	/**
	 * 金额类型：
RENT:租金
DAMAGE:赔偿金
	 */
	@ApiField("pay_amount_type")
	private String payAmountType;

	/**
	 * 信用借还的产品码:w1010100000000002858
	 */
	@ApiField("product_code")
	private String productCode;

	/**
	 * 物品归还门店名称
	 */
	@ApiField("restore_shop_name")
	private String restoreShopName;

	/**
	 * 物品归还时间
	 */
	@ApiField("restore_time")
	private String restoreTime;

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayAmountType() {
		return this.payAmountType;
	}
	public void setPayAmountType(String payAmountType) {
		this.payAmountType = payAmountType;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getRestoreShopName() {
		return this.restoreShopName;
	}
	public void setRestoreShopName(String restoreShopName) {
		this.restoreShopName = restoreShopName;
	}

	public String getRestoreTime() {
		return this.restoreTime;
	}
	public void setRestoreTime(String restoreTime) {
		this.restoreTime = restoreTime;
	}

}
