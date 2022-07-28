package com.beamofsoul.test.demo.example;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 监听特定配置文件内容变更事件
 */
@Log
@Component
public class ConfigListenerExample {

    /**
     * Nacos dataId.
     */
    public static final String DATA_ID = "nacos-config.yaml";

    /**
     * Nacos group.
     */
    public static final String GROUP = "DEFAULT_GROUP";

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @PostConstruct
    public void init() throws NacosException {
        ConfigService configService = nacosConfigManager.getConfigService();
        configService.addListener(DATA_ID, GROUP, new Listener() {
            public Executor getExecutor() {
                return Executors.newSingleThreadExecutor();
            }

            public void receiveConfigInfo(String configInfo) {
                log.info("[dataId]:[" + DATA_ID + "], Configuration changed to:" + configInfo);
            }
        });
    }
}
