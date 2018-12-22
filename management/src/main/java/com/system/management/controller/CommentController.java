package com.system.management.controller;

import com.system.management.dao.CommentMapper;
import com.system.management.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;
    /**
     * 获取用户留言
     * @return
     */
    @RequestMapping(value = "/comment")
    @ResponseBody
    public List<Comment> getComment() {
        List<Comment> msg = commentMapper.getComment();
        return msg;
    }

    /**
     * 用户留言评论
     * @return
     */
    @RequestMapping(value = "/comment/save")
    @ResponseBody
    public int saveComment(@RequestParam String username,@RequestParam String text) {
        int msg = commentMapper.saveComment(username,text);
        return msg;
    }
}
