package com.system.management.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * 响应模板
 */
public class Msg {
    private int status;
    private JSONObject date;

    public Msg(int status, JSONObject date) {
        this.status = status;
        this.date = date;
    }

    public Msg(int status) {
        this.status = status;
    }

    public Msg() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JSONObject getDate() {
        return date;
    }

    public void setDate(JSONObject date) {
        this.date = date;
    }
}
