package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 口碑外部投放授权领券接口
 *
 * @author auto create
 * @since 1.0, 2017-12-22 11:02:09
 */
public class KoubeiAdvertDeliveryItemApplyModel extends AlipayObject {

	private static final long serialVersionUID = 4743765619296179849L;

	/**
	 * 领券时触发的id，在外投场景下，用的是广告id
	 */
	@ApiField("adv_id")
	private String advId;

	/**
	 * 渠道编号，适用于媒体类发券
	 */
	@ApiField("channel_code")
	private String channelCode;

	/**
	 * 适用于在推广者主站上注册的渠道编号
	 */
	@ApiField("channel_id")
	private String channelId;

	/**
	 * 外部流水号，用于区别每次请求的流水号
	 */
	@ApiField("out_biz_no")
	private String outBizNo;

	/**
	 * 券推荐时输出给合作伙伴的id，需要在领券的时候传回来
	 */
	@ApiField("recommend_id")
	private String recommendId;

	/**
	 * 领取优惠的门店id
	 */
	@ApiField("shop_id")
	private String shopId;

	/**
	 * 推广参与打标(无实际业务作用，后期可供ISV分析不同渠道的推广效能)
	 */
	@ApiField("tag")
	private String tag;

	public String getAdvId() {
		return this.advId;
	}
	public void setAdvId(String advId) {
		this.advId = advId;
	}

	public String getChannelCode() {
		return this.channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelId() {
		return this.channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getOutBizNo() {
		return this.outBizNo;
	}
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getRecommendId() {
		return this.recommendId;
	}
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getTag() {
		return this.tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

}
