package com.example.mysecurity.auth.service;

import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.auth.entity.AuthUserDetail;
import com.example.mysecurity.service.SardlineUserRoleService;
import com.example.mysecurity.service.SardlineUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthUserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private SardlineUserService userService;

    @Resource
    private SardlineUserRoleService sardlineUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //查询用户信息

        SardlineUser user = userService.queryByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", name));
        } else {
            //查找角色
            List<SardlineRole> sardlineUserRoles = sardlineUserRoleService.queryRolesByUserId(user.getUserId());
//            List<String> roles =  roleService.getRolesByUserName(username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (SardlineRole role : sardlineUserRoles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            log.info("loadUserByUsername......user ===>{}",user);
            return new AuthUserDetail(user.getUserName(), user.getPassWord(), user.getState(), authorities);
        }
    }
}
