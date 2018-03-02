package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 小程序版本详情查询
 *
 * @author auto create
 * @since 1.0, 2017-12-20 10:42:45
 */
public class AlipayOpenMiniVersionDetailQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4556466753795452545L;

	/**
	 * 小程序版本号
	 */
	@ApiField("app_version")
	private String appVersion;

	public String getAppVersion() {
		return this.appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

}
