package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 查询广告接口
 *
 * @author auto create
 * @since 1.0, 2017-10-10 20:29:22
 */
public class KoubeiMarketingAdvertisingQueryModel extends AlipayObject {

	private static final long serialVersionUID = 6125132916639928336L;

	/**
	 * 广告Id，唯一标识一条广告
	 */
	@ApiField("ad_id")
	private String adId;

	public String getAdId() {
		return this.adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}

}
