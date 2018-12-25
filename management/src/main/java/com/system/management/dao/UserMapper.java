package com.system.management.dao;

import com.system.management.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectList();

    void deleteById(int id);

    //User checkIdNumberUnique(String id_number);

    //User checkIdNumberChange(String id_number,int id);

    Integer create(User user);

    void updateById(User user);

    User checkIdNumberChange(User user);

    User checkIdNumberUnique(User user);
}
