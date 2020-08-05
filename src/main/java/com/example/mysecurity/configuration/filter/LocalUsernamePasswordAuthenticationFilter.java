package com.example.mysecurity.configuration.filter;

import com.example.mysecurity.configuration.exception.LocalAuthException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;

            Map<String, String> authBean = null;
            try (InputStream is = request.getInputStream()) {
                authBean = mapper.readValue(is, Map.class);


            } catch (IOException e) {
                new LocalAuthException(e.getMessage());
            }
            try{
                if(!authBean.isEmpty()){
                    //获取账号密码
                    String name=authBean.get(SPRING_SECURITY_FORM_USERNAME_KEY);
                    String password=authBean.get(SPRING_SECURITY_FORM_PASSWORD_KEY);

                    //校验账号密码
                    if()


                }
            }
        }
    }





}
