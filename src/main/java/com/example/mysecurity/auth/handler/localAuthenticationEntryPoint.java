package com.example.mysecurity.auth.handler;

import cn.hutool.json.JSONUtil;
import com.example.mysecurity.auth.exception.LocalAuthException;
import com.example.mysecurity.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class localAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Result result = new Result<>();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //系统异常
        if (exception instanceof LocalAuthException) {
            //系统异常
            result.setCode(401);
            result.setMsg(exception.getMessage());
        }
        try {
            response.getWriter().write(JSONUtil.toJsonStr(result));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
