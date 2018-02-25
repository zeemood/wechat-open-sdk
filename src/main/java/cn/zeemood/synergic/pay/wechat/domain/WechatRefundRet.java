package cn.zeemood.synergic.pay.wechat.domain;

/**
 * 退款返回信息
 * @author zhang.shushan
 * @date 2018年1月22日
 */
public class WechatRefundRet {
	
	//返回状态码
	private String return_code;
	//返回信息
	private String return_msg;
	//业务结果
	private String result_code;
	//错误代码
	private String err_code;
	//错误代码描述
	private String err_code_des;
	//公众账号ID
	private String appid;
	//错误代码描述
	private String mch_id;
	//随机字符串
	private String nonce_str;
	//签名
	private String sign;
	//微信订单号
	private String transaction_id;
	//商户订单号
	private String out_trade_no;
	//商户退款单号
	private String out_refund_no;
	//微信退款单号
	private String refund_id;
	//退款金额
	private int refund_fee;
	/**
	 * 应结退款金额：
	 * 去掉非充值代金券退款金额后的退款金额，
	 * 退款金额=申请退款金额-非充值代金券退款金额，
	 * 退款金额<=申请退款金额
	 */
	private int settlement_refund_fee;
	//币种
	private String fee_type;
	
	/**
	 * 以下三个字段应该是线上线下混合支付使用的
	 */
	//现金结算部分
	private int cash_fee;
	//币种
	private String cash_fee_type;
	//现金退款部分
	private int cash_refund_fee;
	
	/**
	 * 是否连接成功
	 * @return
	 */
	public boolean isContact(){
		return "SUCCESS".equals(this.return_code);
	}
	
	/**
	 * 业务是否成功
	 * @return
	 */
	public boolean isSuccess(){
		if(isContact()){
			return "SUCCESS".equals(this.result_code);
		}
		return false;
	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public int getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(int refund_fee) {
		this.refund_fee = refund_fee;
	}

	public int getSettlement_refund_fee() {
		return settlement_refund_fee;
	}

	public void setSettlement_refund_fee(int settlement_refund_fee) {
		this.settlement_refund_fee = settlement_refund_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public int getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public int getCash_refund_fee() {
		return cash_refund_fee;
	}

	public void setCash_refund_fee(int cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}
	
}
