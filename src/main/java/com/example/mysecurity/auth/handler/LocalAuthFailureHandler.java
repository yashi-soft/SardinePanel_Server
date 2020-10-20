package com.example.mysecurity.auth.handler;

import com.example.mysecurity.auth.JsonAuth;
import com.example.mysecurity.common.Result;
import com.example.mysecurity.common.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class LocalAuthFailureHandler extends JsonAuth implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Result result = new Result();
        result.setMsg( "登陆失败");
        result.setCode(ResultCode.AUTHEXCEPTION);
        this.writeJson(httpServletRequest, httpServletResponse, result);
    }
}
