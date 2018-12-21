package com.system.management.dao;

import com.system.management.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment")
    List<Comment> getComment();

    @Update("UPDATE comment set username=#{username},text=#{text} WHERE id = #{id}")
    int saveComment(@Param("username") String username,@Param("text") String text,@Param("id") int id);
}
