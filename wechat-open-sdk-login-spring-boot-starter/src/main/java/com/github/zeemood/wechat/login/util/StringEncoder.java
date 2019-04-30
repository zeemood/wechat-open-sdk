package com.github.zeemood.wechat.login.util;

import java.io.UnsupportedEncodingException;

/**
 * 字符串编码转化工具
 *
 * @author zhang.shushan
 * @date 2019/4/30
 */
public class StringEncoder {

    public static String encode(String content, String originalCharset, String targetCharset) {
        try {
            return new String(content.getBytes(originalCharset), targetCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

}
