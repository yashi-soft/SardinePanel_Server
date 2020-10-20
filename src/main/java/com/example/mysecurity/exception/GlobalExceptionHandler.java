package com.example.mysecurity.exception;

import cn.hutool.json.JSONUtil;
import com.example.mysecurity.auth.exception.LocalAccessDeniedException;
import com.example.mysecurity.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * Created by es on 2018/3/13.
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler  {

    /**
     * 所有异常报错
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public void allExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //打印错误日志
        Result result = new Result<>();
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
