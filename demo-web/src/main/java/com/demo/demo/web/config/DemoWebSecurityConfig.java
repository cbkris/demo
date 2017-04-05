package com.demo.demo.web.config;

import com.demo.demo.web.error.DemoAccessDeniedHandler;
import com.demo.demo.web.security.DemoUserDetailsService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by cb on 2017/3/29.
 * Spring Security配置类
 */
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoWebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    DemoAccessDeniedHandler demoAccessDeniedHandler;
    @Autowired
    DemoUserDetailsService demoUserDetailsService;



    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("cb").password("aaa").roles("ADMIN");
        //不删除凭据
        auth.eraseCredentials(false);
        //使用自定义的userDetailsService,将密码加密写入数据库
        auth.userDetailsService(demoUserDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

    /**
     * 他们都是SecurityConfigurer的子类
     * request层面的配置
     * 用来定制登录,注销,权限等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关掉csrf防御
        http.csrf().disable();
        //定义异常处理
        http.exceptionHandling().accessDeniedHandler(demoAccessDeniedHandler);
        //自定义响应头
        //http.headers().defaultsDisabled();
        http.authorizeRequests()
                .anyRequest().permitAll();//暂时允许所有request
                //.antMatchers("/css/**", "/index").permitAll()
                //.antMatchers("/user/**").hasRole("ADMIN")
                //.and()
                //.formLogin().loginPage("/login").failureUrl("/login-error");
    }

    /**
     * web层面的配置
     * 用来配置忽略的方法,路径
     * 例如静态文件等
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/index");
    }

    /**
     * 身份验证配置
     * 用于注入自定义身份验证和密码校验规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

}
