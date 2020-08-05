package com.example.mysecurity.configuration.handler;

import com.example.mysecurity.configuration.JsonAuth;
import com.example.mysecurity.configuration.cache.RedisCache;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class LocalAuthSuccessHandler extends JsonAuth implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = RedisCache.getToken(userDetails.getUsername());
        if (token == null) {
            //如果是第一次登陆，token为空，新增一个
            token = jwtUtil.generateToken(userDetails);

            RedisCache.setToken(userDetails.getUsername(), token);
        }

        //查询出菜单，子菜单，按钮，组织

        Map result = new HashMap<>();
        this.writeJson(httpServletRequest, httpServletResponse, result);

    }
}
