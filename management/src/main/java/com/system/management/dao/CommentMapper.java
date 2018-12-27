package com.system.management.dao;

import com.system.management.model.Comment;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface CommentMapper {
    //@Select("SELECT * FROM comment order by id DESC limit 10")
    List<Comment> getComment();

    //@Insert("INSERT INTO comment (username,text)VALUES(#{username},#{text})")
    int saveComment(@Param("username") String username, @Param("text") String text, @Param("comment_time")Date comment_time);
}
