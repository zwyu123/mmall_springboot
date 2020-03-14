package com.mmall.controller.portal;

import com.mmall.constant.Constants;
import com.mmall.pojo.User;
import com.mmall.service.UserService;
import com.mmall.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(HttpSession session, String username, String password) {
        User user = userService.login(username, password);
        session.setAttribute(Constants.CURRENT_USER, user);
        return user;
    }

    @GetMapping("/logout")
    public Response logout(HttpSession session) {
        session.removeAttribute(Constants.CURRENT_USER);
        return Response.builder().message(Constants.SuccessMsg.LOGOUT_SUCCESS).build();
    }

    @PostMapping("/register")
    public Response register(User user) {
        return userService.register(user);
    }
}
