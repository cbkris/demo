package com.demo.demo.web.config;

import com.demo.demo.web.security.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by cb on 2017/3/29.
 * Spring Security配置类
 */
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoWebSecurityConfig extends WebSecurityConfigurerAdapter{
    private static final Logger logger = LoggerFactory.getLogger(DemoWebSecurityConfig.class);

    @Autowired
    DemoAccessDeniedHandler accessDeniedHandler;
    @Autowired
    DemoLoginSuccessHandler loginSuccessHandler;
    @Autowired
    DemoUserDetailsService userDetailsService;
    @Autowired
    DemoUnAuthenticationHandler unAuthenticationHandler;
    @Autowired
    DemoAuthenticationProvider authenticationProvider;
    @Autowired
    DemoRememberMeAuthenticationProvider rememberMeAuthenticationProvider;


    /**
     * 他们都是SecurityConfigurer的子类
     * 资源配置
     * request层面的配置
     * 用来定制登录,注销,权限等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("开始配置权限访问路径");
        //关掉csrf防御
        http.csrf().disable();
        //定义异常处理
        http.exceptionHandling()
                //未登录
                .authenticationEntryPoint(unAuthenticationHandler)
                //权限不足
                .accessDeniedHandler(accessDeniedHandler);

        //自定义响应头
        //http.headers().defaultsDisabled();
        http.authorizeRequests()
                .antMatchers("/css/**", "/index","/login","/").permitAll()
                .antMatchers("/user/**").hasRole("admin")
                .anyRequest()
                .authenticated()
                //.permitAll();//暂时允许所有request
                .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login-error")
                    .successHandler(loginSuccessHandler)
                    //.successForwardUrl("/user/index")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/index")
                    .invalidateHttpSession(true)
                .and()
                .rememberMe()
                    //.rememberMeServices(null)
                    //.alwaysRemember(true)
                .and()
                .sessionManagement()
                    .maximumSessions(1).expiredUrl("/login?error=expired");
    }

    /**
     * web层面的配置
     * 配置全局影响的,debug开启,忽略的方法,路径
     * 例如静态文件等
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        logger.debug("开始配置忽略的路径");
        web.ignoring().antMatchers("/js/**","/css/**","/index");
        //super.configure(web);
    }

    /**
     * 身份验证配置
     * 用于注入自定义身份验证和密码校验规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //按顺序添加provider,他会加入到manager的provider中
        logger.debug("开始配置AuthenticationManagerBuilder");
        auth.eraseCredentials(true)
            //.userDetailsService(userDetailsService)
            .authenticationProvider(rememberMeAuthenticationProvider)
            .authenticationProvider(authenticationProvider);
        logger.debug("自定义认证启动成功");

        //super.configure(auth);
    }

}
