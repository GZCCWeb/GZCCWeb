package com.system.management.service.logger;

import com.alibaba.fastjson.JSONObject;
import com.system.management.utils.Msg;

public interface LoggerService {
    public void login(Msg msg, JSONObject loginInfo);
    public void register(Msg msg, JSONObject loginInfo);
}
