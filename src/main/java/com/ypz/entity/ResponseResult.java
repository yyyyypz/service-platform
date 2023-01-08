package com.ypz.entity;

import java.util.HashMap;
import java.util.Map;

public class ResponseResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    // 请求成功状态码
    private static final int CODE_OK = 200;
    // 请求失败状态码
    private static final int CODE_ERR = 500;

    // 无参构造方法
    public ResponseResult() {
        put("code", CODE_OK);
    }

    // 请求失败异常未知
    public static ResponseResult error() {
        return error(CODE_ERR, "未知异常，请联系管理员");
    }

    // 请求失败，可获取异常信息
    public static ResponseResult error(String msg) {
        return error(CODE_ERR, msg);
    }

    // 请求失败，自定义响应编码，并且异常信息可获取
    public static ResponseResult error(int code, String msg) {
        ResponseResult r = new ResponseResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    // 请求成功只返回响应编码
    public static ResponseResult ok() {
        return new ResponseResult();
    }

    // 请求成功只需要成功信息
    public static ResponseResult ok(String msg) {
        ResponseResult r = new ResponseResult();
        r.put("msg", msg);
        return r;
    }

    // 请求成功自定义响应格式
    public static ResponseResult ok(Map<String, Object> map) {
        ResponseResult r = new ResponseResult();
        r.putAll(map);
        return r;
    }

    public ResponseResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
