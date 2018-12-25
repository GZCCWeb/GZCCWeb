package com.system.management.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.management.dao.UserMapper;
import com.system.management.model.User;
import com.system.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @PostMapping(value = "/user/loginService")
    @ResponseBody
    public Map login(@RequestBody User user) {
        JSONObject returnMsg = new JSONObject();
        returnMsg.put("user",user.getUsername());
        return returnMsg;
    }

    @Autowired
    private UserService userService;
    /**
     * 从数据库获取用户的信息
     * @return
     */
    @RequestMapping("/users")
    @ResponseBody
    public List<User> getAll(){
        List<User> users = userService.getAll();
        return users;
    }
    /**
     * 创建一条记录
     * @param user
     * @return
     */
    @RequestMapping("/users/create")
    @ResponseBody
    public User create(@RequestBody User user)  {
        if(userService.checkIdNumberUnique(user)==true){
            System.out.println("数据库没有这个ID");
            return userService.create(user);
        }else{
            return user;
        }


    }
    /**
     * 删除一条记录
     */
    @RequestMapping("/users/deleteById")
    @ResponseBody
    public User delete(@RequestBody User user)  {
        userService.deleteById(user);
        return user;
    }

    /**
     * 更新一条记录
     */
    @RequestMapping("/users/update")
    @ResponseBody
    public User update(@RequestBody User user)  {
        if(userService.checkIdNumberChange(user)==false){
            System.out.println("ID没有被修改");
            userService.update(user);
        }else if(userService.checkIdNumberUnique(user)==true){
            System.out.println("ID修改了但数据库没有这个ID");
            userService.update(user);
        }else{
            return null;
        }
        return user;
    }
}
