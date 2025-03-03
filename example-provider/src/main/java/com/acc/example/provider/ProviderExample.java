package com.acc.example.provider;

import com.acc.accrpc.RpcApplication;
import com.acc.accrpc.bootstrap.ProviderBootstrap;
import com.acc.accrpc.config.RegistryConfig;
import com.acc.accrpc.config.RpcConfig;
import com.acc.accrpc.model.ServiceMetaInfo;
import com.acc.accrpc.model.ServiceRegisterInfo;
import com.acc.accrpc.registry.LocalRegistry;
import com.acc.accrpc.registry.Registry;
import com.acc.accrpc.registry.RegistryFactory;
import com.acc.accrpc.server.HttpServer;
import com.acc.accrpc.server.VertxHttpServer;
import com.acc.example.common.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务提供者示例
 */
public class ProviderExample {

    public static void main(String[] args) {
        // 要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo<UserService> serviceRegisterInfo = new ServiceRegisterInfo<>(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);
    }
}
