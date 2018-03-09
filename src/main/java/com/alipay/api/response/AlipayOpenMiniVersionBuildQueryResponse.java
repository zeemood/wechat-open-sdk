package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.open.mini.version.build.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-12-20 10:42:54
 */
public class AlipayOpenMiniVersionBuildQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7155253212534351135L;

	/** 
	 * 构建的状态，0-构建排队中；1-正在构建；2-构建成功；3-构建失败；5-构建超时
	 */
	@ApiField("build_status")
	private String buildStatus;

	/** 
	 * 是否需要轮询
	 */
	@ApiField("need_rotation")
	private String needRotation;

	/** 
	 * 是否创建版本
	 */
	@ApiField("version_created")
	private String versionCreated;

	public void setBuildStatus(String buildStatus) {
		this.buildStatus = buildStatus;
	}
	public String getBuildStatus( ) {
		return this.buildStatus;
	}

	public void setNeedRotation(String needRotation) {
		this.needRotation = needRotation;
	}
	public String getNeedRotation( ) {
		return this.needRotation;
	}

	public void setVersionCreated(String versionCreated) {
		this.versionCreated = versionCreated;
	}
	public String getVersionCreated( ) {
		return this.versionCreated;
	}

}
