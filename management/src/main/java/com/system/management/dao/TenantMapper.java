package com.system.management.dao;

import com.system.management.model.Tenant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;

@Mapper
public interface TenantMapper {
    @Select("SELECT * FROM utilities WHERE room_id = #{room_id}")
    Tenant[] selectByRoomID(int room_id);

    @Update("UPDATE utilities set pay_status='已缴费',pay_date = #{pay_date} WHERE id = #{id}")
    int payByID(@Param("id") int id, @Param("pay_date") Date pay_date);
}