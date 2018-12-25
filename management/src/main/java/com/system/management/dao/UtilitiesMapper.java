package com.system.management.dao;

import com.system.management.model.Fee;

import java.util.List;

public interface UtilitiesMapper {
    List<Fee> getAll();
    Integer insert(Fee fee);   //插入
    Integer update(Fee fee);    //更新
    int deleteById(Integer id);   //删除
}
