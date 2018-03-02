package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 保险批单项
 *
 * @author auto create
 * @since 1.0, 2017-11-30 13:57:01
 */
public class InsEndorseItem extends AlipayObject {

	private static final long serialVersionUID = 4534194784695136854L;

	/**
	 * 批单项新值
	 */
	@ApiField("new_value")
	private String newValue;

	/**
	 * 批单项旧值
	 */
	@ApiField("old_value")
	private String oldValue;

	/**
	 * 批单类型;303:保单改期;311:批改保单标的
	 */
	@ApiField("type")
	private Long type;

	public String getNewValue() {
		return this.newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getOldValue() {
		return this.oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public Long getType() {
		return this.type;
	}
	public void setType(Long type) {
		this.type = type;
	}

}
