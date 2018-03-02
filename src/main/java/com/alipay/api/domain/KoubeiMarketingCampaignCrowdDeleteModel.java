package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 口碑商户人群组删除接口
 *
 * @author auto create
 * @since 1.0, 2017-08-30 14:59:00
 */
public class KoubeiMarketingCampaignCrowdDeleteModel extends AlipayObject {

	private static final long serialVersionUID = 5725664534628368342L;

	/**
	 * 人群组的唯一标识ID
	 */
	@ApiField("crowd_group_id")
	private String crowdGroupId;

	public String getCrowdGroupId() {
		return this.crowdGroupId;
	}
	public void setCrowdGroupId(String crowdGroupId) {
		this.crowdGroupId = crowdGroupId;
	}

}
