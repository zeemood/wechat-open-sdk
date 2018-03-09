package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 操作广告接口
 *
 * @author auto create
 * @since 1.0, 2017-10-10 20:29:39
 */
public class KoubeiMarketingAdvertisingOperateModel extends AlipayObject {

	private static final long serialVersionUID = 1357748786344414692L;

	/**
	 * 广告ID，唯一标识一条广告
	 */
	@ApiField("ad_id")
	private String adId;

	/**
	 * 操作类型，目前包括上线和下线(ONLINE和OFFLINE)
	 */
	@ApiField("operate_type")
	private String operateType;

	public String getAdId() {
		return this.adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getOperateType() {
		return this.operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

}
