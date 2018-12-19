package com.system.management.model;

public class User {
    private int id;
    private String username;
    private String sex;
    private String roomId;
    private String registerDatetime;
    private String phoneNumber;
    private String idNumber;



    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRegisterDatetime() {
        return registerDatetime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setRegisterDatetime(String registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }



}
