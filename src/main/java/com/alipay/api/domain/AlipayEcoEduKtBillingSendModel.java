package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 教育缴费账单发送接口
 *
 * @author auto create
 * @since 1.0, 2017-12-20 11:40:22
 */
public class AlipayEcoEduKtBillingSendModel extends AlipayObject {

	private static final long serialVersionUID = 5448118935452867313L;

	/**
	 * 总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 */
	@ApiField("amount")
	private String amount;

	/**
	 * 缴费账单名称
	 */
	@ApiField("charge_bill_title")
	private String chargeBillTitle;

	/**
	 * 缴费详情：输入json格式字符串。Json定义：key填写缴费项名称，value填写缴费项金额，金额保留2位小数
	 */
	@ApiListField("charge_item")
	@ApiField("charge_items")
	private List<ChargeItems> chargeItem;

	/**
	 * 缴费项模式：空或"N"，表示缴费项不可选，
"M"表示缴费项为可选 ，支持单选和多选。
	 */
	@ApiField("charge_type")
	private String chargeType;

	/**
	 * 孩子名字
	 */
	@ApiField("child_name")
	private String childName;

	/**
	 * 孩子所在班级
	 */
	@ApiField("class_in")
	private String classIn;

	/**
	 * 截止日期是否生效，与gmt_end_time发布配合使用,N为gmt_end_time不生效，用户过期后仍可以缴费；Y为gmt_end_time生效，用户过期后，不能再缴费。
	 */
	@ApiField("end_enable")
	private String endEnable;

	/**
	 * 缴费截止时间，格式"yyyy-MM-dd HH:mm:ss"
	 */
	@ApiField("gmt_end")
	private String gmtEnd;

	/**
	 * 孩子所在年级
	 */
	@ApiField("grade")
	private String grade;

	/**
	 * ISV端的缴费账单编号
	 */
	@ApiField("out_trade_no")
	private String outTradeNo;

	/**
	 * Isv支付宝pid, 支付宝签约后，返回给ISV编号
	 */
	@ApiField("partner_id")
	private String partnerId;

	/**
	 * 学校编码，录入学校接口返回的参数
	 */
	@ApiField("school_no")
	private String schoolNo;

	/**
	 * 学校支付宝pid
	 */
	@ApiField("school_pid")
	private String schoolPid;

	/**
	 * 用于删除孩子，状态为“D”，表示删除孩子，状态“U”表示孩子信息添加或更新
	 */
	@ApiField("status")
	private String status;

	/**
	 * 学生的学号，一般以教育局学号为准，作为学生的唯一标识。此字段与student_identify、家长user_mobile至少选一个
	 */
	@ApiField("student_code")
	private String studentCode;

	/**
	 * 学生的身份证号，如果ISV有学生身份证号，则同步身份证号作为学生唯一标识。此字段与student_code、家长user_mobile至少选一个。
大陆身份证必须是18位 ， 其它地区或国家的身份证开头需要加"IC"开头区分并且不超过18位，但查询账单的时候不要带"IC"
	 */
	@ApiField("student_identify")
	private String studentIdentify;

	/**
	 * 孩子的家长信息，最多一次输入10个家长，此字段做为识别家长的孩子用，与student_identify、student_code至少选一个
	 */
	@ApiListField("users")
	@ApiField("user_details")
	private List<UserDetails> users;

	public String getAmount() {
		return this.amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getChargeBillTitle() {
		return this.chargeBillTitle;
	}
	public void setChargeBillTitle(String chargeBillTitle) {
		this.chargeBillTitle = chargeBillTitle;
	}

	public List<ChargeItems> getChargeItem() {
		return this.chargeItem;
	}
	public void setChargeItem(List<ChargeItems> chargeItem) {
		this.chargeItem = chargeItem;
	}

	public String getChargeType() {
		return this.chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getChildName() {
		return this.childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getClassIn() {
		return this.classIn;
	}
	public void setClassIn(String classIn) {
		this.classIn = classIn;
	}

	public String getEndEnable() {
		return this.endEnable;
	}
	public void setEndEnable(String endEnable) {
		this.endEnable = endEnable;
	}

	public String getGmtEnd() {
		return this.gmtEnd;
	}
	public void setGmtEnd(String gmtEnd) {
		this.gmtEnd = gmtEnd;
	}

	public String getGrade() {
		return this.grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getSchoolNo() {
		return this.schoolNo;
	}
	public void setSchoolNo(String schoolNo) {
		this.schoolNo = schoolNo;
	}

	public String getSchoolPid() {
		return this.schoolPid;
	}
	public void setSchoolPid(String schoolPid) {
		this.schoolPid = schoolPid;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentCode() {
		return this.studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentIdentify() {
		return this.studentIdentify;
	}
	public void setStudentIdentify(String studentIdentify) {
		this.studentIdentify = studentIdentify;
	}

	public List<UserDetails> getUsers() {
		return this.users;
	}
	public void setUsers(List<UserDetails> users) {
		this.users = users;
	}

}
