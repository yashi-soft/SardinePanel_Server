package com.example.mysecurity.entity.base;

import lombok.Data;

@Data
public class PageParm {

    /*第几页*/
    private Integer pageNum;

    /*每页多少条*/
    private Integer pageSize;

}
