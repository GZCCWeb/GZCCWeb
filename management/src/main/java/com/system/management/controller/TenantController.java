package com.system.management.controller;

import com.system.management.dao.TenantMapper;
import com.system.management.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
public class TenantController {

    @Autowired
    private TenantMapper tenantMapper;

    @Autowired
    HttpServletRequest request;

    /**
     * 获取所有账单
     * @param room_id
     * @return
     */
    @RequestMapping(value = "/bill")
    @ResponseBody
    public List<Tenant> getBill() {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("room_id",201);


        int room_id = (int) httpSession.getAttribute("room_id");

        List<Tenant> msg = tenantMapper.getBillByRoomId(room_id);
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
