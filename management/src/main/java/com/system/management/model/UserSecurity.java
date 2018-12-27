package com.system.management.model;

/**
 *  用户安全
 */
public class UserSecurity {
    private int id;
    private String number;
    private String email;
    private String account;
    private String password;
    private String role;
    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserSecurity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
