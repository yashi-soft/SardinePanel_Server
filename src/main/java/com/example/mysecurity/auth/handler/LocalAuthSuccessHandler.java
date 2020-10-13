package com.example.mysecurity.auth.handler;

import cn.hutool.core.bean.BeanUtil;
import com.example.mysecurity.common.Result;
import com.example.mysecurity.common.ResultCode;
import com.example.mysecurity.auth.JsonAuth;
import com.example.mysecurity.auth.cache.RedisCache;
import com.example.mysecurity.entity.*;
import com.example.mysecurity.service.*;
import com.example.mysecurity.vo.MenuVo;
import com.example.mysecurity.vo.RoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LocalAuthSuccessHandler extends JsonAuth implements AuthenticationSuccessHandler {

    @Autowired
    private SardlineMenuService sardlineMenuService;

    @Resource
    private SardlineUserService sardlineUserService;

    @Resource
    private SardlineUserRoleService sardlineUserRoleService;
    @Resource
    private SardlineRoleMenuService sardlineRoleMenuService;
    @Resource
    private SardlineRoleService sardlineRoleService;

    @Resource
    private SardlineUserOrgService sardlineUserOrgService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String name = userDetails.getUsername();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = RedisCache.getToken(name);
        if (token == null) {
            //如果是第一次登陆，token为空，新增一个
            token = jwtUtil.generateToken(userDetails);

            RedisCache.setToken(name, token);
        }


        SardlineUser sardlineUser = sardlineUserService.queryByName(name);

        List<SardlineUserOrg> sardlineUserOrgs = sardlineUserOrgService.queryByUserId(sardlineUser.getUserId());


        List<SardlineUserRole> sardlineUserRoles = sardlineUserRoleService.queryByUserId(sardlineUser.getUserId());

        List<RoleVo> roles = new ArrayList<>();

        Map<String, MenuVo> allMenu = new HashMap();
        String rootid = "-1";

        for (SardlineUserRole role : sardlineUserRoles) {


            SardlineRole sardlineRole = sardlineRoleService.queryById(role.getRoleId());


            List<SardlineMenu> menus = sardlineRoleMenuService.queryByRoleId(role.getRoleId());

            for (SardlineMenu menu : menus) {
                allMenu.put(menu.getMenuId(), BeanUtil.toBean(menu, MenuVo.class));
            }


            for (SardlineMenu menu : menus) {
                MenuVo vo = BeanUtil.toBean(menu,MenuVo.class);
                String pid = vo.getPid();
                if (pid != null) {
                    MenuVo menu1 = allMenu.get(pid);
                    menu1.getChildren().add(vo);
                }
            }

            RoleVo roleVo = BeanUtil.toBean(sardlineRole, RoleVo.class);

//            RoleVo roleVo = (RoleVo) sardlineRole;
            roleVo.setMenuVo(allMenu.get(rootid));
            roles.add(roleVo);

        }

        //查询出菜单，子菜单，按钮，
        Map data = new HashMap();
        data.put("token", token);


//        sardlineMenuService.

        data.put("roles", roles);
        data.put("dept", sardlineUserOrgs);
        data.put("userInfo", sardlineUser);

        Result<Map> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("登录成功");
        result.setData(data);

        this.writeJson(httpServletRequest, httpServletResponse, result);

    }
}
