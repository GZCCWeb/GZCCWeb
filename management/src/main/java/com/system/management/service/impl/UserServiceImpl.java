package com.system.management.service.impl;

import com.system.management.dao.UserMapper;
import com.system.management.model.User;
import com.system.management.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     *获取数据库数据
     */
    @Override
    public List<User> getAll() {
        return userMapper.selectList(null);
    }


    /**
     *插入一条数据
     */
    @Override
    public User create(User user) {
        userMapper.insert(user);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .orderByDesc("id")
                .last("LIMIT 1");
        User userNew=userMapper.selectOne(queryWrapper);
        return userNew;
    }


    /**
     *更新一条数据
     */
    @Override
    public User update(User user) {
        userMapper.updateById(user);
        return null;
    }


    /**
     *删除一条数据
     */
    @Override
    public User deleteById(User user){
        userMapper.deleteById(user.getId());
        return null;
    }

    /**
     *检查身份证号的唯一性
     */
    @Override
    public Boolean checkIdNumberUnique(User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .eq("id_number",user.getIdNumber());
        User checkId=userMapper.selectOne(queryWrapper);
        if(checkId==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     *检查身份证号是否被修改
     */
    @Override
    public Boolean checkIdNumberChange(User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .eq("id",user.getId())
                .eq("id_number",user.getIdNumber());
        User checkId=userMapper.selectOne(queryWrapper);
        if (checkId==null){
            return true;
        }else{
            return false;
        }

    }



//    @Override
//    public User updateId(User user){
//        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//        QueryWrapper<User> updateWrapper=new QueryWrapper<>();
//        queryWrapper
//                .gt("id",user.getId());
//        List<User> users=userMapper.selectList(queryWrapper);
//        for(User userList:users){
//            userList.setId(userList.getId()-1);
//
//            updateWrapper
//                    .eq("id_number",userList.getIdNumber());
//            System.out.println("新数据：Id"+userList.getId()+" 名字"+userList.getUsername());
//            System.out.println("插入到身份证="+userList.getIdNumber());
//
//            System.out.println("----------------调试结束---------------");
//
//            userMapper.update(userList,updateWrapper);
//        }
//        return null;
//    }








}
