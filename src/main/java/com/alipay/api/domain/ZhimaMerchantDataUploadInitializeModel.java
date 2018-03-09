package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 芝麻数据传入初始化
 *
 * @author auto create
 * @since 1.0, 2017-05-27 22:38:45
 */
public class ZhimaMerchantDataUploadInitializeModel extends AlipayObject {

	private static final long serialVersionUID = 8666873417619653759L;

	/**
	 * 数据应用的场景编码 ，场景码和场景名称（数字为场景码）如下：
1:负面披露
2:信用足迹
3:负面+足迹
4:信用守护
5:负面+守护
6:足迹+守护
7:负面+足迹+守护
8:数据反馈
32:骑行
	 */
	@ApiField("scene_code")
	private String sceneCode;

	public String getSceneCode() {
		return this.sceneCode;
	}
	public void setSceneCode(String sceneCode) {
		this.sceneCode = sceneCode;
	}

}
