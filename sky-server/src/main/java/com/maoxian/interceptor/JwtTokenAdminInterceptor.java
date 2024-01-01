package com.maoxian.interceptor;

import com.maoxian.constant.JwtClaimsConstant;
import com.maoxian.context.BaseContext;
import com.maoxian.properties.JwtProperties;
import com.maoxian.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理端员工-jwt令牌拦截器
 *
 * @author Lin
 * @date 2023/12/31 14:22
 */
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 校验jwt
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理
     * @return 放行
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 拦截到的不是Controller方法
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token = request.getHeader(jwtProperties.getAdminTokenName());

        try {
            log.info("jwt校验：{}", token);
            Claims claims = JwtUtil.parseJwt(jwtProperties.getAdminSecretKey(), token);
            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            log.info("当前员工id：{}", empId);
            // 将员工id存入到ThreadLocal
            BaseContext.setCurrentId(empId);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
