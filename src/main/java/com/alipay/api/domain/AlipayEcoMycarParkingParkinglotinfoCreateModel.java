package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 车生活停车平台录入停车场信息
 *
 * @author auto create
 * @since 1.0, 2017-09-27 10:29:28
 */
public class AlipayEcoMycarParkingParkinglotinfoCreateModel extends AlipayObject {

	private static final long serialVersionUID = 2347672468791179355L;

	/**
	 * 城市编号（国家统一标准编码），请务必填写正确，详见 <a href="http://park-cityid.oss-cn-hangzhou.aliyuncs.com/%E5%9F%8E%E5%B8%82%E7%BC%96%E7%A0%81%28%E5%9B%BD%E6%A0%87%E7%A0%81%29.xls">点此下载</a>
	 */
	@ApiField("city_id")
	private String cityId;

	/**
	 * 停车场联系人支付宝账户，如果有则填入
	 */
	@ApiField("contact_alipay")
	private String contactAlipay;

	/**
	 * 停车场联系人邮箱，如果有则填入
	 */
	@ApiField("contact_emali")
	private String contactEmali;

	/**
	 * 停车场联系人手机，如果有则填入
	 */
	@ApiField("contact_mobile")
	private String contactMobile;

	/**
	 * 停车场联系人，如果有则填入
	 */
	@ApiField("contact_name")
	private String contactName;

	/**
	 * 停车场联系人座机，如果有则填入
	 */
	@ApiField("contact_tel")
	private String contactTel;

	/**
	 * 停车场联系人微信，如果有则填入
	 */
	@ApiField("contact_weixin")
	private String contactWeixin;

	/**
	 * 设备商名称
	 */
	@ApiField("equipment_name")
	private String equipmentName;

	/**
	 * 纬度，最长15位字符(包括小数点)，注：高德坐标系。经纬度是门店搜索和活动推荐的重要参数，录入时请确保经纬度参数的准确。高德经纬度询：http://lbs.amap.com/console/show/picker
	 */
	@ApiField("latitude")
	private String latitude;

	/**
	 * 经度，最长15位字符(包括小数点)，注：高德坐标系。经纬度是门店搜索和活动推荐的重要参数，录入时请确保经纬度参数的准确。高德经纬度询：http://lbs.amap.com/console/show/picker
	 */
	@ApiField("longitude")
	private String longitude;

	/**
	 * ISV停车场ID，由ISV提供，同一个isv或商户范围内唯一
	 */
	@ApiField("out_parking_id")
	private String outParkingId;

	/**
	 * 停车场地址
	 */
	@ApiField("parking_address")
	private String parkingAddress;

	/**
	 * 停车场结束营业时间，格式 "HH:mm:ss"
	 */
	@ApiField("parking_end_time")
	private String parkingEndTime;

	/**
	 * 收费说明
	 */
	@ApiField("parking_fee_description")
	private String parkingFeeDescription;

	/**
	 * 停车场类型，1为小区停车场、2为商圈停车场、3为路面停车场、4为园区停车场、5为写字楼停车场、6为私人停车场
	 */
	@ApiField("parking_lot_type")
	private String parkingLotType;

	/**
	 * 停车场名称
	 */
	@ApiField("parking_name")
	private String parkingName;

	/**
	 * 停车位数目
	 */
	@ApiField("parking_number")
	private String parkingNumber;

	/**
	 * 停车场开始营业时间，格式 "HH:mm:ss"
	 */
	@ApiField("parking_start_time")
	private String parkingStartTime;

	/**
	 * 停车场类型(1为地面，2为地下，3为路边)（多个类型，中间用,隔开
	 */
	@ApiField("parking_type")
	private String parkingType;

	/**
	 * 支付方式（1为支付宝在线缴费，2为支付宝代扣缴费，3当面付)，如支持多种方式以','进行间隔
	 */
	@ApiField("pay_type")
	private String payType;

	/**
	 * 缴费模式（1为停车卡缴费，2为物料缴费，3为中央缴费机）
	 */
	@ApiField("payment_mode")
	private String paymentMode;

	/**
	 * 商圈id
	 */
	@ApiField("shopingmall_id")
	private String shopingmallId;

	/**
	 * 用户支付未离场的超时时间(以分钟为单位)
	 */
	@ApiField("time_out")
	private String timeOut;

	public String getCityId() {
		return this.cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getContactAlipay() {
		return this.contactAlipay;
	}
	public void setContactAlipay(String contactAlipay) {
		this.contactAlipay = contactAlipay;
	}

	public String getContactEmali() {
		return this.contactEmali;
	}
	public void setContactEmali(String contactEmali) {
		this.contactEmali = contactEmali;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return this.contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactWeixin() {
		return this.contactWeixin;
	}
	public void setContactWeixin(String contactWeixin) {
		this.contactWeixin = contactWeixin;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getLatitude() {
		return this.latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getOutParkingId() {
		return this.outParkingId;
	}
	public void setOutParkingId(String outParkingId) {
		this.outParkingId = outParkingId;
	}

	public String getParkingAddress() {
		return this.parkingAddress;
	}
	public void setParkingAddress(String parkingAddress) {
		this.parkingAddress = parkingAddress;
	}

	public String getParkingEndTime() {
		return this.parkingEndTime;
	}
	public void setParkingEndTime(String parkingEndTime) {
		this.parkingEndTime = parkingEndTime;
	}

	public String getParkingFeeDescription() {
		return this.parkingFeeDescription;
	}
	public void setParkingFeeDescription(String parkingFeeDescription) {
		this.parkingFeeDescription = parkingFeeDescription;
	}

	public String getParkingLotType() {
		return this.parkingLotType;
	}
	public void setParkingLotType(String parkingLotType) {
		this.parkingLotType = parkingLotType;
	}

	public String getParkingName() {
		return this.parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public String getParkingNumber() {
		return this.parkingNumber;
	}
	public void setParkingNumber(String parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public String getParkingStartTime() {
		return this.parkingStartTime;
	}
	public void setParkingStartTime(String parkingStartTime) {
		this.parkingStartTime = parkingStartTime;
	}

	public String getParkingType() {
		return this.parkingType;
	}
	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public String getPayType() {
		return this.payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPaymentMode() {
		return this.paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getShopingmallId() {
		return this.shopingmallId;
	}
	public void setShopingmallId(String shopingmallId) {
		this.shopingmallId = shopingmallId;
	}

	public String getTimeOut() {
		return this.timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

}
