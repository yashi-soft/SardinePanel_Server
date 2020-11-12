package com.example.mysecurity.auth;

import com.example.mysecurity.auth.filter.LocalUsernamePasswordAuthenticationFilter;
import com.example.mysecurity.auth.filter.YaxiOncePerResuestFilter;
import com.example.mysecurity.auth.handler.*;
import com.example.mysecurity.utils.BCryptPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
public class YaxiWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private LocalAuthSuccessHandler successHandler;
    @Autowired
    private LocalAuthFailureHandler failureHandler;
    @Autowired
    @Qualifier("authUserDetailServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordUtil bCryptPasswordUtil;

    //退出处理器
    @Autowired
    private LocalLogoutHandler localLogoutHandler;
    @Autowired
    private LocalLogoutSuccessHandler logoutSuccessHandler;


    @Autowired
    private YaxiOncePerResuestFilter yaxiOncePerResuestFilter;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordUtil);
    }

    //重写configure方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//解决跨域问题   放行所有preflight request
        http.authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest)
                .permitAll();

//让Security不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers()
                .cacheControl();
        http.authorizeRequests().
                antMatchers(HttpMethod.POST, "/user/register").permitAll();
        http.authorizeRequests().
                antMatchers(HttpMethod.POST, "/swagger-ui.html").permitAll().
                anyRequest().access("@methodCheckUtil.checkMethod(request,authentication)");

        http.addFilterAt(localUsernamePasswordAuthenticationFilter(), LocalUsernamePasswordAuthenticationFilter.class);

        http.addFilterBefore(yaxiOncePerResuestFilter, UsernamePasswordAuthenticationFilter.class);
        http.formLogin();
        http.logout().addLogoutHandler(localLogoutHandler).logoutSuccessHandler(logoutSuccessHandler);
        http.exceptionHandling().accessDeniedHandler(new LocalAccessDeniedHandler());
//        http.exceptionHandling().authenticationEntryPoint(new localAuthenticationEntryPoint())
//                .accessDeniedHandler(new LocalAccessDeniedHandler());
    }

    @Bean
    LocalUsernamePasswordAuthenticationFilter localUsernamePasswordAuthenticationFilter() throws Exception {
        LocalUsernamePasswordAuthenticationFilter filter = new LocalUsernamePasswordAuthenticationFilter();
        //成功的处理
        filter.setAuthenticationSuccessHandler(successHandler);
        //失败的处理
        filter.setAuthenticationFailureHandler(failureHandler);
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;

    }


}
