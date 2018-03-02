package com.alipay.api.response;

import java.util.Date;
import java.util.List;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.domain.VoucherDetail;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.trade.pay response.
 * 
 * @author auto create
 * @since 1.0, 2018-01-03 18:35:24
 */
public class AlipayTradePayResponse extends AlipayResponse {

	private static final long serialVersionUID = 6167181141768282922L;

	/** 
	 * 异步支付模式，先享后付业务会返回该参数，目前有三种值：
ASYNC_DELAY_PAY(异步延时付款);
ASYNC_REALTIME_PAY(异步准实时付款);
SYNC_DIRECT_PAY(同步直接扣款);
	 */
	@ApiField("async_payment_mode")
	private String asyncPaymentMode;

	/** 
	 * 商户传入业务信息，具体值要和支付宝约定
将商户传入信息分发给相应系统，应用于安全，营销等参数直传场景
格式为json格式
	 */
	@ApiField("business_params")
	private String businessParams;

	/** 
	 * 买家支付宝账号
	 */
	@ApiField("buyer_logon_id")
	private String buyerLogonId;

	/** 
	 * 买家付款的金额
	 */
	@ApiField("buyer_pay_amount")
	private String buyerPayAmount;

	/** 
	 * 买家在支付宝的用户id
	 */
	@ApiField("buyer_user_id")
	private String buyerUserId;

	/** 
	 * 买家用户类型。CORPORATE:企业用户；PRIVATE:个人用户。
	 */
	@ApiField("buyer_user_type")
	private String buyerUserType;

	/** 
	 * 支付宝卡余额
	 */
	@ApiField("card_balance")
	private String cardBalance;

	/** 
	 * 平台优惠金额
	 */
	@ApiField("discount_amount")
	private String discountAmount;

	/** 
	 * 本次交易支付所使用的单品券优惠的商品优惠信息
	 */
	@ApiField("discount_goods_detail")
	private String discountGoodsDetail;

	/** 
	 * 交易支付使用的资金渠道
	 */
	@ApiListField("fund_bill_list")
	@ApiField("trade_fund_bill")
	private List<TradeFundBill> fundBillList;

	/** 
	 * 交易支付时间
	 */
	@ApiField("gmt_payment")
	private Date gmtPayment;

	/** 
	 * 交易中可给用户开具发票的金额
	 */
	@ApiField("invoice_amount")
	private String invoiceAmount;

	/** 
	 * 商家优惠金额
	 */
	@ApiField("mdiscount_amount")
	private String mdiscountAmount;

	/** 
	 * 买家支付宝用户号,该参数已废弃，请不要使用
	 */
	@ApiField("open_id")
	private String openId;

	/** 
	 * 商户订单号
	 */
	@ApiField("out_trade_no")
	private String outTradeNo;

	/** 
	 * 使用集分宝付款的金额
	 */
	@ApiField("point_amount")
	private String pointAmount;

	/** 
	 * 实收金额
	 */
	@ApiField("receipt_amount")
	private String receiptAmount;

	/** 
	 * 发生支付交易的商户门店名称
	 */
	@ApiField("store_name")
	private String storeName;

	/** 
	 * 交易金额
	 */
	@ApiField("total_amount")
	private String totalAmount;

	/** 
	 * 支付宝交易号
	 */
	@ApiField("trade_no")
	private String tradeNo;

	/** 
	 * 本交易支付时使用的所有优惠券信息
	 */
	@ApiListField("voucher_detail_list")
	@ApiField("voucher_detail")
	private List<VoucherDetail> voucherDetailList;

	public void setAsyncPaymentMode(String asyncPaymentMode) {
		this.asyncPaymentMode = asyncPaymentMode;
	}
	public String getAsyncPaymentMode( ) {
		return this.asyncPaymentMode;
	}

	public void setBusinessParams(String businessParams) {
		this.businessParams = businessParams;
	}
	public String getBusinessParams( ) {
		return this.businessParams;
	}

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}
	public String getBuyerLogonId( ) {
		return this.buyerLogonId;
	}

	public void setBuyerPayAmount(String buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}
	public String getBuyerPayAmount( ) {
		return this.buyerPayAmount;
	}

	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	public String getBuyerUserId( ) {
		return this.buyerUserId;
	}

	public void setBuyerUserType(String buyerUserType) {
		this.buyerUserType = buyerUserType;
	}
	public String getBuyerUserType( ) {
		return this.buyerUserType;
	}

	public void setCardBalance(String cardBalance) {
		this.cardBalance = cardBalance;
	}
	public String getCardBalance( ) {
		return this.cardBalance;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getDiscountAmount( ) {
		return this.discountAmount;
	}

	public void setDiscountGoodsDetail(String discountGoodsDetail) {
		this.discountGoodsDetail = discountGoodsDetail;
	}
	public String getDiscountGoodsDetail( ) {
		return this.discountGoodsDetail;
	}

	public void setFundBillList(List<TradeFundBill> fundBillList) {
		this.fundBillList = fundBillList;
	}
	public List<TradeFundBill> getFundBillList( ) {
		return this.fundBillList;
	}

	public void setGmtPayment(Date gmtPayment) {
		this.gmtPayment = gmtPayment;
	}
	public Date getGmtPayment( ) {
		return this.gmtPayment;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getInvoiceAmount( ) {
		return this.invoiceAmount;
	}

	public void setMdiscountAmount(String mdiscountAmount) {
		this.mdiscountAmount = mdiscountAmount;
	}
	public String getMdiscountAmount( ) {
		return this.mdiscountAmount;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getOutTradeNo( ) {
		return this.outTradeNo;
	}

	public void setPointAmount(String pointAmount) {
		this.pointAmount = pointAmount;
	}
	public String getPointAmount( ) {
		return this.pointAmount;
	}

	public void setReceiptAmount(String receiptAmount) {
		this.receiptAmount = receiptAmount;
	}
	public String getReceiptAmount( ) {
		return this.receiptAmount;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreName( ) {
		return this.storeName;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getTotalAmount( ) {
		return this.totalAmount;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getTradeNo( ) {
		return this.tradeNo;
	}

	public void setVoucherDetailList(List<VoucherDetail> voucherDetailList) {
		this.voucherDetailList = voucherDetailList;
	}
	public List<VoucherDetail> getVoucherDetailList( ) {
		return this.voucherDetailList;
	}

}
