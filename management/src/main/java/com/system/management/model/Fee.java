package com.system.management.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.annotation.Id;

@EntityScan
public class Fee {

    private Integer id;
    private int room_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String fee_date;
    private double water_fee;
    private double electric_fee;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String pay_date;
    private String pay_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getFee_date() {
        return fee_date;
    }

    public void setFee_date(String fee_date) {
        this.fee_date = fee_date;
    }

    public double getWater_fee() {
        return water_fee;
    }

    public void setWater_fee(double water_fee) {
        this.water_fee = water_fee;
    }

    public double getElectric_fee() {
        return electric_fee;
    }

    public void setElectric_fee(double electric_fee) {
        this.electric_fee = electric_fee;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }

}
