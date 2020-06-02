package com.chen.web;

import com.chen.po.User;
import com.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String register(){
        return "register";
    }

    @PostMapping("/goRegister")
    public String Doregister(User user, Model model){
        User find = userService.checkUser(user.getUsername(),user.getPassword());
        System.err.println(find);
        if (find == null){
            userService.saveUser(user);
            return "admin/login";
        }else {
            model.addAttribute("message","用户已存在");
            return "register";
        }
    }
}
