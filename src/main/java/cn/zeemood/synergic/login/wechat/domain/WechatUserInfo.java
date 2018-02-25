package cn.zeemood.synergic.login.wechat.domain;

/**
 * 微信授权信息类
 * @author zhang.shushan
 * @date 2018年1月18日
 */
public class WechatUserInfo extends ErrorDomain{
	
	//应用唯一标识
	private String openid;
	//微信昵称
	private String nickname;
	//性别 1-男 2-女
	private int sex;
	//省
	private String provice;
	//城市
	private String city;
	//国家
	private String country;
	//头像地址
	private String headimgurl;
	//特权信息
	private String[] privilege;
	//开放平台唯一标识
	private String unionid;

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String[] getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}
