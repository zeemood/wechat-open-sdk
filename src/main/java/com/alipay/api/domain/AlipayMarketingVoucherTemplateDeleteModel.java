package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 删除资金券模板
 *
 * @author auto create
 * @since 1.0, 2017-06-19 11:27:18
 */
public class AlipayMarketingVoucherTemplateDeleteModel extends AlipayObject {

	private static final long serialVersionUID = 3644617841222945185L;

	/**
	 * 券模板ID
	 */
	@ApiField("template_id")
	private String templateId;

	public String getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
