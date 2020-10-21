package com.example.mysecurity.utils;

;
import com.example.mysecurity.auth.exception.LocalAccessDeniedException;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.service.SardlineApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
@Slf4j
public class MethodCheckUtil {

    @Autowired
    SardlineApiService service;


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
            List<SardlineApi> apiUrls = service.getApiUrlByUserName(username);

            //查询通用接口

            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //当前访问路径
            String requestURI = request.getRequestURI();

            //提交类型
            String urlMethod = request.getMethod();
            log.info("requestURI======={}:urlMethod=========={}", requestURI, urlMethod);
            // System.out.println("DynamicPermission requestURI = " + requestURI);

            //判断当前路径中是否在资源鉴权中
            boolean rs = apiUrls.stream().anyMatch(item -> {
                //判断URL是否匹配
                boolean hashAntPath = antPathMatcher.match(item.getApiUrl(), requestURI);

                //判断请求方式是否和数据库中匹配（数据库存储：GET,POST,PUT,DELETE）
                String dbMethod = item.getApiMethod();

                //处理null，万一数据库存值
                dbMethod = (dbMethod == null) ? "" : dbMethod;
                int hasMethod = dbMethod.indexOf(urlMethod);

                //两者都成立，返回真，否则返回假
                return hashAntPath && (hasMethod != -1);
            });
            //返回

            log.info("check method status===={}", rs);
            if (rs) {
                return rs;
            } else {
                throw new LocalAccessDeniedException("您没有访问该API的权限！");

            }

        } else {
            throw new LocalAccessDeniedException("不是UserDetails类型！");
        }
    }
}

























