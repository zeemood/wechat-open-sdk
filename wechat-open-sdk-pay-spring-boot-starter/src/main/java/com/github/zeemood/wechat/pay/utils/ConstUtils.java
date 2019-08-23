package com.github.zeemood.wechat.pay.utils;

import java.math.BigDecimal;

/**
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/16 0:32
 */
public class ConstUtils {
    public static final int STR_LENGTH_32 = 32;
    public static final int STR_LENGTH_256 = 256;
    public static final BigDecimal NUMERIC_HUNDRED = BigDecimal.TEN.multiply(BigDecimal.TEN);


    public static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String REFUND_APPLY_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    public static BigDecimal bigDecimalConverter(BigDecimal decimal){
        return decimal==null?BigDecimal.ZERO:decimal.divide(ConstUtils.NUMERIC_HUNDRED);
    }
}
