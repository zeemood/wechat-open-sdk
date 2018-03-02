package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 口碑商品交易凭证模板
 *
 * @author auto create
 * @since 1.0, 2018-01-03 11:23:15
 */
public class KoubeiTradeVoucherItemTemplete extends AlipayObject {

	private static final long serialVersionUID = 6314576338186632859L;

	/**
	 * 购买须知，列表类型，最多10项
	 */
	@ApiListField("buyer_notes")
	@ApiField("koubei_item_description")
	private List<KoubeiItemDescription> buyerNotes;

	/**
	 * 表示是否支持预定，支持“T”, 不支持“F”
	 */
	@ApiField("support_book")
	private String supportBook;

	/**
	 * 购买有效期：商品自购买起多长时间内有效，取值范围 7-360，单位天。举例，如果是7的话，是到第七天晚上23:59:59失效。商品购买后，没有在有效期内核销，则自动退款给用户。举例：买了一个高级造型师洗剪吹的商品，有效期一个月，如果一个月之后，用户没有使用商品来进行洗剪吹的服务，则自动退款给用户。
	 */
	@ApiField("validity_period")
	private String validityPeriod;

	public List<KoubeiItemDescription> getBuyerNotes() {
		return this.buyerNotes;
	}
	public void setBuyerNotes(List<KoubeiItemDescription> buyerNotes) {
		this.buyerNotes = buyerNotes;
	}

	public String getSupportBook() {
		return this.supportBook;
	}
	public void setSupportBook(String supportBook) {
		this.supportBook = supportBook;
	}

	public String getValidityPeriod() {
		return this.validityPeriod;
	}
	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

}
