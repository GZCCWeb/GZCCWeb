package com.system.management.controller;

import com.system.management.dao.TestMapper;
import com.system.management.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  测试环境是否搭建完好类
 */
@Controller
@ResponseBody
public class TestController {
    /**
     * 测试映射是否可行
     * @return
     */
    @RequestMapping(value = "/testPage")
    @ResponseBody
    public String testPage() {
        return "this is testPage";
    }

    @Autowired
    private TestMapper testMapper;

    @RequestMapping(value = "/mysqlTest")
    public String mysql() {
        System.out.println("mysql测试开始");
        TestModel testModel = testMapper.selectByID(1);
        System.out.println("testModel = " + testModel);
        return testModel+"";
    }
}
