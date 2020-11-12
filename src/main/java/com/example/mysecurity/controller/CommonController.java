package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("common")
public class CommonController {

    /**
     *
     * @param selectIds
     * @return
     */
    @GetMapping("getSelectIds")
    public Result<String> getSelectIds(String selectIds) {
        return Result.success(selectIds);
    }

}
