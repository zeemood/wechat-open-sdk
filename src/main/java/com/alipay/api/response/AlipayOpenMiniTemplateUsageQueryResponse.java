package com.alipay.api.response;

import java.util.List;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.open.mini.template.usage.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-12-21 22:06:39
 */
public class AlipayOpenMiniTemplateUsageQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3821257688389425589L;

	/** 
	 * 小程序appId列表
	 */
	@ApiListField("app_ids")
	@ApiField("string")
	private List<String> appIds;

	public void setAppIds(List<String> appIds) {
		this.appIds = appIds;
	}
	public List<String> getAppIds( ) {
		return this.appIds;
	}

}
