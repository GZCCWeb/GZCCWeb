package com.system.management.dao;

import com.system.management.model.Tenant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TenantMapper {
    @Select("SELECT * FROM utilities WHERE room_id = #{roomId}")
    Tenant[] selectByRoomID(int roomId);

    @Update("UPDATE utilities set pay_status='已缴费' WHERE id = #{id}")
    int payByID(int id);
}