package cn.zeemood.synergic.pay.wechat.domain;

import cn.zeemood.synergic.pay.wechat.utils.WechatPayConfigurations;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * 微信支付信息实体类
 *
 * @author zhang.shushan
 * @date 2018年1月19日
 */
public class WechatPayInfo {

    // 应用ID
    private String appid;
    // 商户号
    private String mch_id;
    // 终端设备号(门店号或收银设备ID)，默认请传"WEB"
    private String device_info = "WEB";
    // 随机字符串
    private String nonce_str;
    // 签名，信息填充完整后使用工具类设置签名
    private String sign;
    // 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
    private String sign_type = "MD5";
    /**
     * 商品描述交易字段格式根据不同的应用场景按照以下格式：
     * APP——需传入应用市场上的APP名字-实际商品名称，
     * 天天爱消除-游戏充值。
     */
    private String body;
    // 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
    private String attach;
    // 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
    private String out_trade_no;
    // 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见
    private String fee_type = "CNY";
    // 订单总金额，单位为分
    private int total_fee;
    //订单详情，用于单个商品的优惠，设置成对象的json
    private String detail;
    // 用户端实际ip
    private String spbill_create_ip;
    // 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
    private String notify_url;
    // 交易类型
    private String trade_type;
    // 该字段用于统一下单时上报场景信息，目前支持上报实际门店信息，设置成对象的json
    private String scene_info;
    //微信公众号支付必填
    private String openid;
    //限制使用信用卡支付
    private String limit_pay;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    /**
     * 设置限制使用信用卡
     */
    public void configureLimitPay(){
        this.limit_pay="no_credit";
    }

    /**
     * 设置必填的自定义参数
     *
     * @param body
     * @param out_trade_no
     * @param total_fee
     * @param suffix
     * @param trade_type
     * @throws IOException
     */
    public WechatPayInfo(String body, String out_trade_no, String suffix,
                         int total_fee,
                         String trade_type, String spbill_create_ip) throws IOException {
        this.body = WechatPayConfigurations.getAppName() + "-" + body;
        this.out_trade_no = out_trade_no;
        this.notify_url = WechatPayConfigurations.getNotifyUrl(suffix);
        this.trade_type = trade_type;
        this.spbill_create_ip = spbill_create_ip;
        if (!WechatPayConfigurations.getPayEnvironment()) {
            this.total_fee = 1;
        } else {
            this.total_fee = total_fee;
        }
    }

    /**
     * 设置必填的自定义参数
     *
     * @param body
     * @param out_trade_no
     * @param total_fee
     * @param notify_url
     * @param trade_type
     * @throws IOException
     */
    public WechatPayInfo(String body, String out_trade_no,
                         int total_fee, String notify_url,
                         String trade_type, String spbill_create_ip) throws IOException {
        this.body = WechatPayConfigurations.getAppName() + "-" + body;
        this.out_trade_no = out_trade_no;
        this.notify_url = notify_url;
        this.trade_type = trade_type;
        this.spbill_create_ip = spbill_create_ip;
        if (!WechatPayConfigurations.getPayEnvironment()) {
            this.total_fee = 1;
        } else {
            this.total_fee = total_fee;
        }
    }

    //获取订单总价，可自行修改，主要是根据不同环境切换不同的支付价格
    public int getTotal_fee() {
        //如果是生产环境，使用原价
        if (WechatPayConfigurations.getPayEnvironment()) {
            return this.total_fee;
        }
        //如果是测试环境，返回1分钱
        return 1;
    }

    /**
     * 设置单品优惠信息
     *
     * @param orderInfos
     */
    public void configDetail(OrderInfos orderInfos) {
        this.detail = JSON.toJSONString(orderInfos);
    }

    /**
     * 设置实际门店信息
     *
     * @param sceneInfo
     */
    public void configScene_info(SceneInfo sceneInfo) {
        this.scene_info = JSON.toJSONString(sceneInfo);
    }

    /**
     * 设置必填的自定义参数
     *
     * @param body
     * @param out_trade_no
     * @param total_fee
     * @param notify_url
     * @param trade_type
     * @throws IOException
     */
    public void configMajorParameters(String body, String out_trade_no,
                                      int total_fee, String notify_url,
                                      String trade_type, String spbill_create_ip) throws IOException {
        this.body = WechatPayConfigurations.getAppName() + "-" + body;
        this.out_trade_no = out_trade_no;
        this.notify_url = notify_url;
        this.trade_type = trade_type;
        this.spbill_create_ip = spbill_create_ip;
        if (!WechatPayConfigurations.getPayEnvironment()) {
            this.total_fee = 1;
        } else {
            this.total_fee = total_fee;
        }
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

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
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

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getScene_info() {
        return scene_info;
    }

    public void setScene_info(String scene_info) {
        this.scene_info = scene_info;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

}
