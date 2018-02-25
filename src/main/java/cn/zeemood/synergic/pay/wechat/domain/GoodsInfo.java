package cn.zeemood.synergic.pay.wechat.domain;

/**
 * 单品列表项
 * 
 * @author zhang.shushan
 * @date 2018年1月22日
 */
public class GoodsInfo {

	//商品编码
	private String goods_id;
	//微信支付定义的统一商品编号（没有可不传）
	private String wxpay_goods_id;
	//商品的实际名称
	private String goods_name;
	//商品数量
	private int quantity;
	//优惠后的商品单价
	private int price;
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getWxpay_goods_id() {
		return wxpay_goods_id;
	}
	public void setWxpay_goods_id(String wxpay_goods_id) {
		this.wxpay_goods_id = wxpay_goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
