package com.example.mysecurity.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @author 小二的马
 */

@Data
public class SysMenuEntity {


    private String frontendMenuId;

    private String frontendMenuName;

    private String frontendMenuUrl;

    private String pid;

    private Integer frontendMenuSort;

    private String description;

}
