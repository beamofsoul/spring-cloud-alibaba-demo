package com.beamofsoul.test.demo.grpc.lb;

import io.grpc.LoadBalancerRegistry;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 注册自定义负载均衡策略
 * 且仅在配置文件中配置grpc.client.__service_name__.default-load-balancing-policy后生效
 * grpc:
 *   client:
 *     GLOBAL:
 *       default-load-balancing-policy: custom_round_robin # policy_name {@link CustomLoadBalancerProvider#getPolicyName()}
 */
@Configuration
public class CustomLoadBalanceConfiguration {

    @PostConstruct
    public void registry() {
        CustomLoadBalancerProvider customLoadBalancerProvider = new CustomLoadBalancerProvider();
        LoadBalancerRegistry.getDefaultRegistry().register(customLoadBalancerProvider);
    }
}
