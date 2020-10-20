package com.example.mysecurity.auth.filter;

import com.example.mysecurity.auth.exception.LocalAuthException;
import com.example.mysecurity.service.SardlineUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class LocalUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private SardlineUserService sardlineUserService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

//        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
        if (request.getContentType().equals(MediaType.MULTIPART_FORM_DATA) || request.getContentType().equals(MediaType.MULTIPART_FORM_DATA_VALUE)) {

            UsernamePasswordAuthenticationToken authRequest = null;
            Map<String, String[]> authBean = request.getParameterMap();


            try {
                if (!authBean.isEmpty()) {
                    //获取账号密码
                    String username = authBean.get(SPRING_SECURITY_FORM_USERNAME_KEY)[0];
                    String password = authBean.get(SPRING_SECURITY_FORM_PASSWORD_KEY)[0];
//                    String username = authBean.get(SPRING_SECURITY_FORM_USERNAME_KEY);
//                    String password = authBean.get(SPRING_SECURITY_FORM_PASSWORD_KEY);

                    //校验账号密码
                    if (sardlineUserService.checkLogin(username, password)) {
                        //将账号、密码装入UsernamePasswordAuthenticationToken中
                        authRequest = new UsernamePasswordAuthenticationToken(username, password);
                        setDetails(request, authRequest);
                        return this.getAuthenticationManager().authenticate(authRequest);
                    } else {
                        throw new LocalAuthException("账号或者密码错误");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
