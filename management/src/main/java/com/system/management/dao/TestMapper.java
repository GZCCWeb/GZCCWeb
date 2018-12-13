package com.system.management.dao;

import com.system.management.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
    @Select("SELECT * FROM test_table WHERE id = #{id}")
    TestModel selectByID(int id);
}