package com.beamofsoul.test.demo.example;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.common.utils.StringUtils;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 通过接口操作配置信息
 */
@Log
@RestController
@RequestMapping("/nacos")
public class DockingInterfaceExample {

    /**
     * Nacos group.
     */
    public static final String DEFAULT_GROUP = "DEFAULT_GROUP";

    private NacosConfigManager nacosConfigManager;
    private ConfigService configService;

    public DockingInterfaceExample(NacosConfigManager nacosConfigManager) {
        this.nacosConfigManager = nacosConfigManager;
        this.configService = nacosConfigManager.getConfigService();
    }

    /**
     * Get configuration information.
     * @param dataId dataId
     * @param group group
     * @return config
     * @throws NacosException query config from nacos server failed
     */
    @GetMapping("/getConfig")
    public String getConfig(@RequestParam String dataId, @RequestParam(required = false) String group) throws NacosException {
        return configService.getConfig(dataId, getValidGroup(group), 2000);
    }

    /**
     * Publish configuration.
     * @param dataId dataId
     * @param group group
     * @param content content
     * @return boolean
     * @throws NacosException publish config from nacos server failed
     */
    @GetMapping("/publishConfig")
    public boolean publishConfig(@RequestParam String dataId, @RequestParam(required = false) String group, @RequestParam String content) throws NacosException {
        return configService.publishConfig(dataId, getValidGroup(group), content);
    }

    /**
     * Delete configuration.
     * @param dataId dataId
     * @param group group
     * @return boolean
     * @throws NacosException remove config from nacos server failed
     */
    @GetMapping("/removeConfig")
    public boolean removeConfig(@RequestParam String dataId, @RequestParam(required = false) String group) throws NacosException {
        return configService.removeConfig(dataId, getValidGroup(group));
    }

    /**
     * Add listener configuration information.
     * @param dataId dataId
     * @param group group
     * @return config listener message
     * @throws NacosException add listener to nacos server failed
     */
    @GetMapping("/listener")
    public String listenerConfig(@RequestParam String dataId, @RequestParam(required = false) String group) throws NacosException {
        ConfigService configService = nacosConfigManager.getConfigService();
        configService.addListener(dataId, getValidGroup(group), new Listener() {
            public Executor getExecutor() {
                return Executors.newSingleThreadExecutor();
            }

            public void receiveConfigInfo(String configInfo) {
                log.info("[Listen for configuration changes]:" + configInfo);
            }
        });
        return "Add Listener successfully!";
    }

    private String getValidGroup(String inputGroup) {
        return StringUtils.isBlank(inputGroup) ? DEFAULT_GROUP : inputGroup;
    }
}
