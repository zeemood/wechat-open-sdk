package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 定损宝查询图像定损结果
 *
 * @author auto create
 * @since 1.0, 2017-08-07 17:31:25
 */
public class AlipayInsDataDsbEstimateQueryModel extends AlipayObject {

	private static final long serialVersionUID = 6634995756885428494L;

	/**
	 * 定损单号
	 */
	@ApiField("estimate_no")
	private String estimateNo;

	/**
	 * 车架号
	 */
	@ApiField("frame_no")
	private String frameNo;

	/**
	 * 车牌号
	 */
	@ApiField("license_no")
	private String licenseNo;

	public String getEstimateNo() {
		return this.estimateNo;
	}
	public void setEstimateNo(String estimateNo) {
		this.estimateNo = estimateNo;
	}

	public String getFrameNo() {
		return this.frameNo;
	}
	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}

	public String getLicenseNo() {
		return this.licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

}
