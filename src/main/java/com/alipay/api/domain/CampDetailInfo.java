package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 营销活动详情信息
 *
 * @author auto create
 * @since 1.0, 2017-12-20 11:44:43
 */
public class CampDetailInfo extends AlipayObject {

	private static final long serialVersionUID = 3278453721525967293L;

	/**
	 * 活动开始时间
	 */
	@ApiField("begin_time")
	private String beginTime;

	/**
	 * 业务id，与bizType 一一对应，如：biz_type为消费送，biz_id为消费送活动id
	 */
	@ApiField("biz_id")
	private String bizId;

	/**
	 * 业务类型：CONSUME_SEND：消费送；MRT_DISCOUNT:商户立减；OBTAIN:通用领券
	 */
	@ApiField("biz_type")
	private String bizType;

	/**
	 * 活动描述
	 */
	@ApiField("camp_desc")
	private String campDesc;

	/**
	 * 需要解析该json串，title为标题，details是描述，多个detail需要换行
	 */
	@ApiField("camp_guide")
	private String campGuide;

	/**
	 * 活动结束时间
	 */
	@ApiField("end_time")
	private String endTime;

	/**
	 * 扩展字段信息，用Map对象json串保存
	 */
	@ApiField("ext_info")
	private String extInfo;

	/**
	 * 每人每日参与次数 -1为不限制
	 */
	@ApiField("win_limit_daily")
	private String winLimitDaily;

	/**
	 * 每人总参与次数 -1 为不限制
	 */
	@ApiField("win_limit_life")
	private String winLimitLife;

	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getBizId() {
		return this.bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getCampDesc() {
		return this.campDesc;
	}
	public void setCampDesc(String campDesc) {
		this.campDesc = campDesc;
	}

	public String getCampGuide() {
		return this.campGuide;
	}
	public void setCampGuide(String campGuide) {
		this.campGuide = campGuide;
	}

	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getExtInfo() {
		return this.extInfo;
	}
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}

	public String getWinLimitDaily() {
		return this.winLimitDaily;
	}
	public void setWinLimitDaily(String winLimitDaily) {
		this.winLimitDaily = winLimitDaily;
	}

	public String getWinLimitLife() {
		return this.winLimitLife;
	}
	public void setWinLimitLife(String winLimitLife) {
		this.winLimitLife = winLimitLife;
	}

}
