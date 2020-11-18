package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineUserBehaviour;
import com.example.mysecurity.service.SardlineUserBehaviourService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sardlineUserBehaviour")
public class SardlineUserBehaviourController {
    @Resource
    private SardlineUserBehaviourService sardlineUserBehaviourService;

    @GetMapping("behaviourList")
    public Result<List<SardlineUserBehaviour>> userBehaviourList(String userId, String startTime){
        return Result.success(this.sardlineUserBehaviourService.queryById(userId,startTime));
    }
    @GetMapping("selectByName")
    public Result<List<SardlineUserBehaviour>> userBehaviourList(String username){
        return Result.success(this.sardlineUserBehaviourService.queryByName(username));
    }
}
