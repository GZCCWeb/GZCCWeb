package com.system.management.controller;

import com.system.management.dao.TenantMapper;
import com.system.management.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TenantController {

    @Autowired
    private TenantMapper tenantMapper;

    @RequestMapping(value = "/bill")
    @ResponseBody
    public Tenant[] getBill(/*@RequestBody int roomId*/) {
        Tenant[] msg = tenantMapper.selectByRoomID(202);
        System.out.println( msg[0].getPay_status()+" cnmcnm ");
        return msg;
    }
}
