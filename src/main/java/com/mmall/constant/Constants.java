package com.mmall.constant;

public class Constants {
    public static final String CURRENT_USER = "currentUser";

    public interface Role {
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1; //管理员
    }

    public static class ErrorMsg {
        public static final String USER_EXIST = "用户已存在";
        public static final String USER_NOT_EXIST = "用户不存在";
        public static final String PASSWORD_ERROR = "密码错误";
        public static final String EMAIL_EXIST = "email已存在";
        public static final String REGISTER_FAILED = "注册失败";
    }

    public static class SuccessMsg {
        public static final String REGISTER_SUCCESS = "注册成功";
        public static final String LOGOUT_SUCCESS = "登出成功";
    }
}
