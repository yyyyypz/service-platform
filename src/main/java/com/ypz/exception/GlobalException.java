package com.ypz.exception;

import com.ypz.entity.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice // 拦截异常
@ResponseBody // 将响应的java对象转换为json数据
public class GlobalException {
    // 指定拦截哪种类型的异常，这里拦截了所有的异常
    @ExceptionHandler(value = Exception.class)
    public ResponseResult exceptionHandler(HttpServletRequest request, Exception e) {
        System.out.println("全局异常");
        return ResponseResult.error("服务端异常，请联系管理员" + "<br/>" + e.getMessage());
    }
}
