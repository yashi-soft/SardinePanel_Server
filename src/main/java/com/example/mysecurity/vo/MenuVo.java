package com.example.mysecurity.vo;

import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.entity.SardlineMenu;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class MenuVo extends SardlineMenu {


    private List<MenuVo> children = new ArrayList<>();

//    private List<ApiVo> apis = new ArrayList<>();
}
