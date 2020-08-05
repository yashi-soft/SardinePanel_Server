package com.example.mysecurity.configuration;

import com.example.mysecurity.configuration.filter.LocalUsernamePasswordAuthenticationFilter;
import com.example.mysecurity.configuration.handler.LocalAuthFailureHandler;
import com.example.mysecurity.configuration.handler.LocalAuthSuccessHandler;
import com.example.mysecurity.configuration.handler.LocalLogoutHandler;
import com.example.mysecurity.configuration.handler.LocalLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;

@Configuration
public class YaxiWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private LocalAuthSuccessHandler successHandler;
    @Autowired
    private LocalAuthFailureHandler failureHandler;


    //退出处理器
    @Autowired
    private LocalLogoutHandler localLogoutHandler;
    @Autowired
    private LocalLogoutSuccessHandler logoutSuccessHandler;

    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder){
        authenticationManagerBuilder.userDetailsService()
    }

    //重写configure方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//解决跨域问题   放行所有preflight request
        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

//让Security不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().headers().cacheControl();

        http.authorizeRequests().antMatchers(HttpMethod.POST, "/user/register").permitAll()


                .anyRequest().access("");
        http.addFilterAt(localUsernamePasswordAuthenticationFilter(), LocalUsernamePasswordAuthenticationFilter.class);

        http.formLogin();
        http.logout().addLogoutHandler(localLogoutHandler).logoutSuccessHandler(logoutSuccessHandler);

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
