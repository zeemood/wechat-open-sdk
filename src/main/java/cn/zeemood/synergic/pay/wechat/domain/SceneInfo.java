package cn.zeemood.synergic.pay.wechat.domain;

import com.alibaba.fastjson.JSON;

/**
 * 微信支付门店信息实体类，转换成json设置到支付信息实体类中的scene_indo
 * @author zhang.shushan
 * @date 2018年1月19日
 */
public class SceneInfo {

	private String store_id;
	private String store_name;
	
	public String getJsonStr(){
		return JSON.toJSONString(this);
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
}
