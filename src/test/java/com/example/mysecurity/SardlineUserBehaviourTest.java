package com.example.mysecurity;


import com.example.mysecurity.entity.SardlineUserBehaviour;
import com.example.mysecurity.service.SardlineApiService;
import com.example.mysecurity.service.SardlineUserBehaviourService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SardlineUserBehaviourTest {
    @Autowired
     SardlineUserBehaviourService sardlineUserBehaviourService;
    @Autowired
    SardlineApiService sardlineApiService;
    @Test
     public void insert(){
        SardlineUserBehaviour sardlineUserBehaviour = new SardlineUserBehaviour();
        sardlineUserBehaviour.setUserId("123456");
        sardlineUserBehaviour.setUserName("Admin");
        sardlineUserBehaviour.setUserUrl("/sardline/login");
        sardlineUserBehaviour.setUserApiType("Post");
        sardlineUserBehaviour.setTime(new Timestamp(new Date().getTime()));
        System.out.println(sardlineUserBehaviourService.insert(sardlineUserBehaviour));
     }
     @Test
     public void queryById(){
         List<SardlineUserBehaviour> list = sardlineUserBehaviourService.queryById("1232421213","2020-11-10");
         for (SardlineUserBehaviour t:  list) {
             System.out.println(t.getUserId()+":"+t.getUserName()+"用户在："+
                     new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(t.getTime()) +";通过："+t.getUserUrl()+",访问"+t.getUserApiType());
         }
     }
     @Test
     public void queryByName(){
         List<SardlineUserBehaviour> list = sardlineUserBehaviourService.queryByName("ad");
         for (SardlineUserBehaviour t:  list) {
             System.out.println(t.getUserId()+":"+t.getUserName()+"用户在："+
                     new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(t.getTime()) +";通过："+t.getUserUrl()+",访问"+t.getUserApiType());
         }
     }
     @Test
     public void queryAll(){
//         System.out.println(sardlineUserBehaviourService.queryAllByLimit(0,50));
//         List<SardlineUserBehaviour> list = sardlineUserBehaviourService.queryAllByLimit(0,10);
//         for (SardlineUserBehaviour t: list
//              ) {
//             System.out.println(t.getTime().toString());
//         }
     }
     @Test
    public void delete(){
         System.out.println(sardlineUserBehaviourService.deleteById("1232"));
     }
     @Test
    public void test1(){
        String apiName = sardlineApiService.getApiNameByUrl("/sardline/user/deleteUser");
         System.out.println(apiName);
     }
}
