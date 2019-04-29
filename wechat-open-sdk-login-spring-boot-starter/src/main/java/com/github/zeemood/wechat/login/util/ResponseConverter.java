package com.github.zeemood.wechat.login.util;

import com.alibaba.fastjson.JSON;
import com.github.zeemood.wechat.login.exception.WechatLoginRespException;
import com.github.zeemood.wechat.login.resp.BaseResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 返回信息
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
public class ResponseConverter {

    public static <T extends BaseResp> T convertAndCheck(ResponseEntity<String> entity, Class<T> clazz) {
        HttpStatus statusCode = entity.getStatusCode();
        if (statusCode != HttpStatus.OK) {
            throw new WechatLoginRespException(statusCode.getReasonPhrase());
        }
        String body = entity.getBody();
        T t = JSON.parseObject(body, clazz);
        if (t.getErrorCode() != 0) {
            throw new WechatLoginRespException(t.getErrorMsg());
        }
        return t;
    }
}
