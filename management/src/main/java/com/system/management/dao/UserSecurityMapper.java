package com.system.management.dao;

import com.system.management.model.UserSecurity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserSecurityMapper {

    void addNewUser(UserSecurity userSecurity);

//    @Select("SELECT user_password FROM user_security WHERE user_account = #{account}")
    String getPasswordByAccount(String account);

    String getUserNumberByAccount(String account);
}
