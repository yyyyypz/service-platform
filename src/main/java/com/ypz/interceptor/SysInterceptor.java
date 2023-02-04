package com.ypz.interceptor;

import com.ypz.utils.JwtUtils;
import com.ypz.utils.StringUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求路径
        String requestURI = request.getRequestURI();
        System.out.println("requestURI=" + requestURI);
        if (handler instanceof HandlerMethod) {
            // 判断token是否为空
            String token = request.getHeader("token");
            System.out.println("token=" + token);
            if (StringUtil.isEmpty(token)) {
                throw new RuntimeException("token校验失败！");
            } else {
                // 如果token不为空则根据token获取claims
                Claims claims = JwtUtils.validateJWT(token).getClaims();
                // 对claims进行判空，如果为空表示鉴权失败，不为空表示鉴权成功
                if (claims == null) {
                    throw new RuntimeException("token鉴权失败！");
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }
}
