package com.system.management.model;

import java.util.Date;

public class Tenant {
    private int id;
    private int room_id;
    private int water_fee;
    private int electric_fee;
    private Date fee_date;
    private Date pay_date;
    private String pay_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getWater_fee() {
        return water_fee;
    }

    public void setWater_fee(int water_fee) {
        this.water_fee = water_fee;
    }

    public int getElectric_fee() {
        return electric_fee;
    }

    public void setElectric_fee(int electric_fee) {
        this.electric_fee = electric_fee;
    }

    public Date getFee_date() {
        return fee_date;
    }

    public void setFee_date(Date fee_date) {
        this.fee_date = fee_date;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }
}
