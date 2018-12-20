package com.system.management.controller;

import com.system.management.dao.TenantMapper;
import com.system.management.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
public class TenantController {

    @Autowired
    private TenantMapper tenantMapper;

    /**
     * 获取所有账单
     * @param room_id
     * @return
     */
    @RequestMapping(value = "/bill")
    @ResponseBody
    public Tenant[] getBill(@RequestParam Integer room_id) {
        Tenant[] msg = tenantMapper.selectByRoomID(room_id);
        return msg;
    }

    /**
     * 支付账单
     * @param id
     * @param pay_date
     * @return
     */
    @RequestMapping(value = "/pay")
    @ResponseBody
    public int payBill(@RequestParam Integer id, @RequestParam Date pay_date) {
        int msg = tenantMapper.payByID(id,pay_date);
        return msg;
    }
}
