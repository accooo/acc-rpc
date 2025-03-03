package com.acc.example.consumer;

import com.acc.accrpc.bootstrap.ConsumerBootstrap;
import com.acc.accrpc.config.RpcConfig;
import com.acc.accrpc.proxy.ServiceProxyFactory;
import com.acc.accrpc.utils.ConfigUtils;
import com.acc.example.common.model.User;
import com.acc.example.common.service.UserService;

/**
 * 服务消费者示例
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 服务消费者初始化
        ConsumerBootstrap.init();

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("accooo");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}
