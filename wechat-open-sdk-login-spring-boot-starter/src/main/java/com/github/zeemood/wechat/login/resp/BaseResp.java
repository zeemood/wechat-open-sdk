package com.github.zeemood.wechat.login.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 微信登录基础返回类。此类只适用于纯后台与微信交互的api
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Data
public class BaseResp {
    /**
     * 正确返回时为0。给默认值是方便判断，因为很多接口正确返回时没有这两个字段，
     * 但是错误返回一定会有。
     */
    @JSONField(name = "errcode")
    private Integer errorCode = 0;
    @JSONField(name = "errmsg")
    private String errorMsg;
}
