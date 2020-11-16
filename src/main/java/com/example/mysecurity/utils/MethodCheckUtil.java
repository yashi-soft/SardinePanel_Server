package com.example.mysecurity.utils;

;
import com.example.mysecurity.auth.exception.LocalAccessDeniedException;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.factory.UsualApiCache;
import com.example.mysecurity.service.SardlineApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class MethodCheckUtil {

    @Autowired
    private SardlineApiService service;



    /**
     * 判断有访问API的权限
     *
     * @param request
     * @param authentication
     * @return
     * @throws LocalAccessDeniedException
     */
    public boolean checkMethod(HttpServletRequest request,
                               Authentication authentication) throws LocalAccessDeniedException {

        Object principal = authentication.getPrincipal();
        log.info("principal = {}", principal.toString());

        if (principal instanceof UserDetails) {

            UserDetails userDetails = (UserDetails) principal;
            //得到当前的账号
            String username = userDetails.getUsername();
            //Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

            // System.out.println("DynamicPermission  username = " + username);
            //通过账号获取资源鉴权
            Map<String,SardlineApi> urlMap = service.getUrlMap(username);

//            UsualApiCache.getMap();
            Map<String,SardlineApi> usualApiUrlMap = service.selectUsualApiMap();
            urlMap.putAll(usualApiUrlMap);

            //查询通用接口

            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //当前访问路径
            String requestURI = request.getRequestURI();

            //提交类型
            String urlMethod = request.getMethod();

            log.info("requestURI======={}\nurlMethod=========={}", requestURI, urlMethod);
            log.info("{}操作了{}方式的{}", username, urlMethod, requestURI);
            Boolean flag = false;
            if (urlMap.get(requestURI) != null) {
                SardlineApi api = urlMap.get(requestURI);
                if (api.getApiMethod().equals(urlMethod)) {
                    //userId,用户信息，url，method，时间,接口描述
                    //插入数据库

                    flag = true;
                }
            }

            log.info("check method status===={}", flag);
            if (flag) {
                return flag;
            } else {
                throw new LocalAccessDeniedException("您没有访问该API的权限！");
            }

        } else {
            throw new LocalAccessDeniedException("不是UserDetails类型！");
        }
    }
}

























