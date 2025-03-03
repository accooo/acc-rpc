package com.acc.accrpc.config;

import com.acc.accrpc.fault.retry.RetryStrategyKeys;
import com.acc.accrpc.fault.tolerant.TolerantStrategyKeys;
import com.acc.accrpc.loadbalancer.LoadBalancerKeys;
import com.acc.accrpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * RPC 框架配置
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "null";

    /**
     * 版本号
     */
    private String version = "null";

    /**
     * 服务器主机名
     */
    private String serverHost = "null";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 404;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.ROUND_ROBIN;

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.NO;

    /**
     * 容错策略
     */
    private String tolerantStrategy = TolerantStrategyKeys.FAIL_FAST;
}
