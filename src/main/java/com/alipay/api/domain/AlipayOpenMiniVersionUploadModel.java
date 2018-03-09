package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 小程序基于模板上传版本
 *
 * @author auto create
 * @since 1.0, 2017-12-20 11:02:08
 */
public class AlipayOpenMiniVersionUploadModel extends AlipayObject {

	private static final long serialVersionUID = 4842335292849977621L;

	/**
	 * 小程序版本号
	 */
	@ApiField("app_version")
	private String appVersion;

	/**
	 * 在一份ext.json文件中，会包含同app.json相同的字段和和app.json不同的字段，同app.json不同的字段详解。extEnable 是一个 Boolean 类型的字段，用于规定当前的 ext.json 文件是否生效，开发者可以通过修改这个字段来开启和关闭 extAppid 的结合开发。
ext 字段是开发自定义的数据字段，在小程序中可以通过 my.getExtConfigSync。
extPages 是一个对象，对象中的每个 key 应该是该小程序模板 app.json 中定义的页面，每个 key 对应的 value 是 page.json 中所规定的各项配置。当开发者设置这个配置以后，小程序框架会对应的修改相对应的 page 的配置信息。
	 */
	@ApiField("ext")
	private String ext;

	/**
	 * 模板id
	 */
	@ApiField("template_id")
	private String templateId;

	public String getAppVersion() {
		return this.appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getExt() {
		return this.ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
