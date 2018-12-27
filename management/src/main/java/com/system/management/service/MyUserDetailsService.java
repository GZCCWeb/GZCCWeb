//package com.system.management.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class  MyUserDetailsService implements UserDetailsService {
//
//    private Logger loggerPage =LoggerFactory.getLogger(getClass());
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        loggerPage.info("登陆用户名"+userName);
//        return new User(userName, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }
//}
