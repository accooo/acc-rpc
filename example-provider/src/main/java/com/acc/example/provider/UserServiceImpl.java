package com.acc.example.provider;

import com.acc.example.common.model.User;
import com.acc.example.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("-----provider------用户名：" + user.getName());
        user.setName("provider change!");
        return user;
    }
}
