package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.domain.IntelligentPromo;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: koubei.marketing.campaign.intelligent.promo.consult response.
 * 
 * @author auto create
 * @since 1.0, 2017-12-22 11:11:39
 */
public class KoubeiMarketingCampaignIntelligentPromoConsultResponse extends AlipayResponse {

	private static final long serialVersionUID = 4474846287476672181L;

	/** 
	 * 智能营销方案咨询的模型
	 */
	@ApiField("promo")
	private IntelligentPromo promo;

	public void setPromo(IntelligentPromo promo) {
		this.promo = promo;
	}
	public IntelligentPromo getPromo( ) {
		return this.promo;
	}

}
