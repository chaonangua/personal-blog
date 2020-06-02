package com.chen.service;

import com.chen.dao.UserRepository;
import com.chen.po.User;
import com.chen.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        //通过 MD5Utils.code(password) : 将密码111111加密为与数据库中根据MD5规则加密后的密码进行判断
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(MD5Utils.code(user.getPassword()));
        return userRepository.save(user);
    }

}
