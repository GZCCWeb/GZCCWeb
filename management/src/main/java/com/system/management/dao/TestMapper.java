package com.system.management.dao;

import com.system.management.model.TestModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    TestModel selectByID(int id);
}