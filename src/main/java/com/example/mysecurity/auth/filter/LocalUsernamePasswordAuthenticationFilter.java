package com.example.mysecurity.auth.filter;

import com.example.mysecurity.auth.exception.LocalAuthException;
import com.example.mysecurity.service.SardlineUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (true) {
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            Map<String, String[]> authBean=request.getParameterMap();

//            Map<String, String> authBean = null;
//            try (InputStream is = request.getInputStream()) {
//                authBean = mapper.readValue(is, Map.class);
//
//
//            } catch (IOException e) {
//                new LocalAuthException(e.getMessage());
//            }
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
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
