//package com.system.management.cofig;
//
//import com.system.management.model.MyPasswordEncoder;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * 配置安全配置
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //设置静态资源不要拦截
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////            .authorizeRequests()
////            .antMatchers("/resources/**, /loggerPage/loginService")
////            .permitAll()
////            .antMatchers("/user/**").hasRole("USER")
////            .antMatchers("/admin/**").hasRole("ADMIN")
////            .and()
////            .formLogin()
////            .loginPage("/login")
////            .permitAll();
////
////        //  注销
////        http
////            .logout()
////            .logoutUrl("/logout")
////            .logoutSuccessUrl("/login")
////            .invalidateHttpSession(true);
//
//        http.formLogin()
////        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //可以设置内存指定的登录的账号密码,指定角色
//        //不加.passwordEncoder(new MyPasswordEncoder())
//        //就不是以明文的方式进行匹配，会报错
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//        //.passwordEncoder(new MyPasswordEncoder())。
//        //这样，页面提交时候，密码以明文的方式进行匹配。
//        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("cxh").password("cxh").roles("ADMIN");
//    }
//}
