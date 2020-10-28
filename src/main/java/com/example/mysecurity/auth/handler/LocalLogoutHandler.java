package com.example.mysecurity.auth.handler;

import com.example.mysecurity.auth.JsonAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LocalLogoutHandler extends JsonAuth implements LogoutHandler {

    private String header = "Authorization";

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        String headerToken = httpServletRequest.getHeader(header);
        log.info("logout header Token = {}", headerToken);
        log.info("logout request getMethod  = {}", httpServletRequest.getMethod());

        //
        if (!StringUtils.isEmpty(headerToken)) {

            String token = headerToken.replace("Bearer", "").trim();
            log.info("authentication ={}", authentication);
//            System.out.println("authentication = " + authentication);
            SecurityContextHolder.clearContext();
        }
    }
}
