package com.mmall.service;

import com.mmall.constant.Constants;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.vo.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            throw new RuntimeException(Constants.ErrorMsg.USER_NOT_EXIST);
        }

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null) {
            throw new RuntimeException(Constants.ErrorMsg.PASSWORD_ERROR);
        }

        user.setPassword(StringUtils.EMPTY);
        return user;
    }

    public Response register(User user) {
        int resultCount = userMapper.checkUsername(user.getUsername());
        if (resultCount > 0) {
            throw new RuntimeException(Constants.ErrorMsg.USER_EXIST);
        }
        resultCount = userMapper.checkEmail(user.getEmail());
        if (resultCount > 0) {
            throw new RuntimeException(Constants.ErrorMsg.EMAIL_EXIST);
        }

        user.setRole(Constants.Role.ROLE_CUSTOMER);
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));

        resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            throw new RuntimeException(Constants.ErrorMsg.REGISTER_FAILED);
        }
        return Response.builder().message(Constants.SuccessMsg.REGISTER_SUCCESS).build();
    }
}
