package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 查询使用ISV模板的托管小程序列表
 *
 * @author auto create
 * @since 1.0, 2017-12-21 22:06:00
 */
public class AlipayOpenMiniTemplateUsageQueryModel extends AlipayObject {

	private static final long serialVersionUID = 7167357649153774489L;

	/**
	 * 查询的页数，默认第一页
	 */
	@ApiField("page_num")
	private Long pageNum;

	/**
	 * 每页的数量，最多查询50个，默认查询10个
	 */
	@ApiField("page_size")
	private Long pageSize;

	/**
	 * 模板id
	 */
	@ApiField("template_id")
	private String templateId;

	public Long getPageNum() {
		return this.pageNum;
	}
	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}

	public Long getPageSize() {
		return this.pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public String getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
