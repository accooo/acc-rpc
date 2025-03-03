package com.acc.accrpc.bootstrap;

import com.acc.accrpc.RpcApplication;
import com.acc.accrpc.config.RegistryConfig;
import com.acc.accrpc.config.RpcConfig;
import com.acc.accrpc.model.ServiceMetaInfo;
import com.acc.accrpc.model.ServiceRegisterInfo;
import com.acc.accrpc.registry.LocalRegistry;
import com.acc.accrpc.registry.Registry;
import com.acc.accrpc.registry.RegistryFactory;
import com.acc.accrpc.server.VertxHttpServer;

import java.util.List;

/**
 * 服务提供者初始化
 */
public class ProviderBootstrap {

    /**
     * 初始化
     */
    public static void init(List<ServiceRegisterInfo<?>> serviceRegisterInfoList) {
        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();
        // 全局配置
        final RpcConfig rpcConfig = RpcApplication.getRpcConfig();

        // 注册服务
        for (ServiceRegisterInfo<?> serviceRegisterInfo : serviceRegisterInfoList) {
            String serviceName = serviceRegisterInfo.getServiceName();
            // 本地注册
            LocalRegistry.register(serviceName, serviceRegisterInfo.getImplClass());

            // 注册服务到注册中心
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName + " 服务注册失败", e);
            }
        }

        // 启动服务器
        VertxHttpServer vertxHttpServer = new VertxHttpServer();
        vertxHttpServer.doStart(rpcConfig.getServerPort());
    }
}
