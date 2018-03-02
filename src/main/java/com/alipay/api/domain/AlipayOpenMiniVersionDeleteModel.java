package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 小程序删除版本
 *
 * @author auto create
 * @since 1.0, 2017-12-20 11:07:54
 */
public class AlipayOpenMiniVersionDeleteModel extends AlipayObject {

	private static final long serialVersionUID = 7668142355926153117L;

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
