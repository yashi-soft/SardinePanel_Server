package com.example.mysecurity;

import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.utils.CheckNullUtil;
import com.example.mysecurity.vo.MenuVo;

import java.util.ArrayList;
import java.util.List;

public class Test1 {


    public static void main(String[] args) {

String name="中";
        System.out.println(name.charAt(0));



        SardlineApi api=new SardlineApi();
        MenuVo vo=new MenuVo();
        MenuVo children=new MenuVo();

        List<MenuVo> list=new ArrayList<>();

        list.add(children);

        api.setApiId(null);

        String s = CheckNullUtil.ofNullable(api).getBean(SardlineApi::getApiId).get();

        List<MenuVo> menuVoList = CheckNullUtil.ofNullable(vo).getBean(MenuVo::getChildren).get();
        System.out.println(menuVoList);

        System.out.println(s);
    }


}
