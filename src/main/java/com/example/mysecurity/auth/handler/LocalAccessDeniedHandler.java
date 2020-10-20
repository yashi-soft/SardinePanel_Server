package com.example.mysecurity.auth.handler;

import cn.hutool.json.JSONUtil;
import com.example.mysecurity.auth.exception.LocalAccessDeniedException;
import com.example.mysecurity.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LocalAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {
        Result result = new Result<>();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //系统异常
        if (exception instanceof LocalAccessDeniedException) {
            //系统异常
            result.setCode(403);
            result.setMsg(exception.getMessage());
        }
        try {
            response.getWriter().write(JSONUtil.toJsonStr(result));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
