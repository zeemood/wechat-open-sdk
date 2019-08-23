package com.github.zeemood.wechat.pay.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.util.Assert;

import java.util.TreeMap;

/**
 * 数据签名工具
 *
 * @author zhang.shushan
 * @date 2019/6/21
 */
public class DataSignatureUtil {

    public static <T> String genSignature(T o, String secret) {
        Assert.notNull(o, "加签对象不能为null");
        //为了减少对其他工具的依赖，可以自己用反射实现，但是还得区别Map和Object
        //我懒，利用fastjson将对象转换JSON再解析为treeMap
        String mapJson = JSON.toJSONString(o);
        TreeMap<String, String> treeMap = JSON.parseObject(mapJson, new TypeReference<TreeMap<String, String>>() {
        });
        treeMap.remove("sign");
        Assert.notEmpty(treeMap, "对象无属性或属性值全为空");
        StringBuffer sb = new StringBuffer(treeMap.size());
        treeMap.forEach((k, s) -> {
            sb.append(k).append("=").append(s).append("&");
        });
        sb.append("key=").append(secret);
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }

    public static <T> boolean checkSign(T o, String secret, String signature) {
        String s = genSignature(o, secret);
        return s.equalsIgnoreCase(signature);
    }

}
