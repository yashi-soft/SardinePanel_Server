package com.example.mysecurity.auth.handler;

import com.example.mysecurity.auth.JsonAuth;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 成功退出处理器
 */
@Component
public class LocalLogoutSuccessHandler extends JsonAuth implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("退出成功。。。。。。");
        Map result = new HashMap();
//        R<String> data = R.ok("退出成功");
        result.put("msg", "退出成功");
        super.writeJson(httpServletRequest, httpServletResponse, result);
    }
}
