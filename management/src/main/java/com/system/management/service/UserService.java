package com.system.management.service;

import com.system.management.model.User;

import java.util.List;

public interface UserService {
    /**
     *获取数据库数据
     */
    List<User> getAll();

    /**
     *插入一条数据
     */
    User create(User user);

    /**
     *更新一条数据
     */
    User update(User user);

    /**
     *删除一条数据
     */
    User deleteById(User user);

    /**
     *检查身份证号的唯一性
     */
    Boolean checkIdNumberUnique(User user);

    /**
     *检查身份证号是否被修改
     */
    Boolean checkIdNumberChange(User user);

}
