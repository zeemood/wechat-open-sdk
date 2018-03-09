package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 智能营销门店咨询
 *
 * @author auto create
 * @since 1.0, 2017-11-17 06:02:44
 */
public class KoubeiMarketingCampaignIntelligentShopConsultModel extends AlipayObject {

	private static final long serialVersionUID = 4869753427574572714L;

	/**
	 * 操作上下文
	 */
	@ApiField("operator_context")
	private PromoOperatorInfo operatorContext;

	/**
	 * 外部业务id，请尽量保持足够的复杂，方便定位数据来源
	 */
	@ApiField("out_request_no")
	private String outRequestNo;

	/**
	 * 当前页码，默认：“1”
	 */
	@ApiField("page_index")
	private String pageIndex;

	/**
	 * 每页项数[1, 500]， 默认500
	 */
	@ApiField("page_size")
	private String pageSize;

	/**
	 * 商户和支付宝交互时，用于代表支付宝分配给商户ID
	 */
	@ApiField("partner_id")
	private String partnerId;

	/**
	 * 智能营销方案的方案id（template_code替代该值，无需传递）
	 */
	@ApiField("plan_id")
	private String planId;

	/**
	 * 营销模板的编号，默认GENERAL_EXPERIENCE（不传值）
可选枚举：
GENERAL_EXPERIENCE：全场体验；
GENERAL_NORMAL：全场普通；
GENERAL_20171212：全场2017双12版；
CROWD_EXPERIENCE：千人千券体验；
CROWD_NORMAL：千人千券普通；
CROWD_20171212：千人千券2017双12版；
	 */
	@ApiField("template_code")
	private String templateCode;

	public PromoOperatorInfo getOperatorContext() {
		return this.operatorContext;
	}
	public void setOperatorContext(PromoOperatorInfo operatorContext) {
		this.operatorContext = operatorContext;
	}

	public String getOutRequestNo() {
		return this.outRequestNo;
	}
	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getPageIndex() {
		return this.pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return this.pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPlanId() {
		return this.planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getTemplateCode() {
		return this.templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

}
