package com.example.mysecurity.vo;

import com.example.mysecurity.entity.SardlineOrganization;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrgVo extends SardlineOrganization {

    private List<OrgVo> children = new ArrayList<>();

}
