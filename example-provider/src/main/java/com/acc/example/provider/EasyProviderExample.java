package com.acc.example.provider;

import com.acc.accrpc.registry.LocalRegistry;
import com.acc.accrpc.server.HttpServer;
import com.acc.accrpc.server.VertxHttpServer;
import com.acc.example.common.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
