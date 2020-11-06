package com.example.mysecurity.auth;

import com.example.mysecurity.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class JsonAuth {
    @Autowired
    protected JwtUtil jwtUtil;

    protected void writeJson(
            HttpServletRequest request,
            HttpServletResponse response,
            Object data) throws IOException, ServletException {
        //把返回转成json格式
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        //输出JSON
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(data));
        out.flush();
        out.close();


    }
}
