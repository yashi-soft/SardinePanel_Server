package com.example.mysecurity.common;

import lombok.Data;

@Data
public class Result<T> {


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this(code, msg, null);
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static Result success(Object object) {
        Result result = new Result();
        result.setMsg("请求成功");
        result.setCode(ResultCode.SUCCESS);
        result.setData(object);
        return result;
    }


}
