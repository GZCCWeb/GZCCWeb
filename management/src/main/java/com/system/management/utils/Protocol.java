package com.system.management.utils;

/**
 * 自定义状态协议类
 */
public class Protocol {
    //  基本状态
    public static final int SUCCESS = 0;                                                                                //  成功
    public static final int ERROR = 1;                                                                                  //  错误
    public static final int INVALIATE = 2;                                                                              //  失效或找不到


    //  登陆注册状态
    public static final int ACCOUNT = 4;                                                                                //  账号
    public static final int PASSWORD = 8;                                                                               //  密码
    public static final int CODE = 16;                                                                                  //  验证码
    public static final int EMAIL = 32;                                                                                 //  邮箱
}
