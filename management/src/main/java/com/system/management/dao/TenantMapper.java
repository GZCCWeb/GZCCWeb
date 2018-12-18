package com.system.management.dao;

import com.system.management.model.Tenant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TenantMapper {
    @Select("SELECT * FROM utilities WHERE room_id = #{roomId}")
    Tenant[] selectByRoomID(int roomId);
}