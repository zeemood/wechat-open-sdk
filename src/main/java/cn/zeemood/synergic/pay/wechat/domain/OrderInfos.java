package cn.zeemood.synergic.pay.wechat.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 支付详情里的detail字段，转成json设置
 * @author zhang.shushan
 * @date 2018年1月22日
 */
public class OrderInfos {
	
	/**
	 * 订单原价
	 * 1.商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
	 * 2.当订单原价与支付金额不相等，则不享受优惠。（主要功能，很费解的一句话）
	 * 3.该字段主要用于防止同一张小票分多次支付，以享受多次优惠的情况，正常支付订单不必上传此参数。
	 */
	private String cost_price;
	//小票id
	private String receipt_id;
	//订单单品信息
	private List<GoodsInfo> goods_detail=new ArrayList<>();
	public String getCost_price() {
		return cost_price;
	}
	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}
	public String getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}
	public List<GoodsInfo> getGoods_detail() {
		return goods_detail;
	}
	public void setGoods_detail(List<GoodsInfo> goods_detail) {
		this.goods_detail = goods_detail;
	}

}
