package com.acc.example.consumer;

import com.acc.accrpc.proxy.ServiceProxyFactory;
import com.acc.example.common.model.User;
import com.acc.example.common.service.UserService;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {

//        // 静态代理
//        UserService userService = new UserServiceProxy();
//        User user = new User();
//        user.setName("accoooo");
//        userService.getUser(user);
//        System.out.printf("User: %s\n", user);

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("acc consumer");
        User user1 = userService.getUser(user);
        System.out.printf("User: %s\n", user1);
    }
}
