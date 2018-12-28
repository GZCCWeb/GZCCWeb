package com.system.management.controller;

import com.system.management.service.UtilitiesService;
import com.system.management.model.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Service
@Controller

public class UtilitiesController {
    @Autowired
    private UtilitiesService utilitiesService;

    @RequestMapping(value = "/utilities")//发送请求，发送users的数据。
    @ResponseBody   //转为json，获取请求为json对象，即javasprict字符串。。
    public List<Fee> getAll(){
        //从数据库获取用户的信息
        List<Fee> fees = utilitiesService.getAll();
        return fees;
    }
    //添加
    @RequestMapping("/utilities/insert")
    @ResponseBody
    //@Valid用于验证注解是否符合要求
    public Integer insert(@Valid Fee fee){
        int num = utilitiesService.insert(fee);
        System.out.println(num);
          return num;
    }

    //更新
    @RequestMapping("/utilities/update")
    @ResponseBody
    public Integer update(@Valid Fee fee){
        //从数据库获取用户的信息
        return utilitiesService.update(fee);
    }

    //删除
    @RequestMapping("/utilities/delete")
    @ResponseBody
    private Integer deleteById(@Valid Integer id){
        return utilitiesService.deleteById(id);
    }




}
