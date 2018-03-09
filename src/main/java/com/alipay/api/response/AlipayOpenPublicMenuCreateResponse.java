package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.open.public.menu.create response.
 * 
 * @author auto create
 * @since 1.0, 2017-10-19 15:33:15
 */
public class AlipayOpenPublicMenuCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 6417452726443776617L;

	/** 
	 * 默认菜单菜单key，文本菜单为“default”，icon菜单为“iconDefault”
	 */
	@ApiField("menu_key")
	private String menuKey;

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}
	public String getMenuKey( ) {
		return this.menuKey;
	}

}
