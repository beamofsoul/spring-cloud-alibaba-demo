package com.beamofsoul.test.demo.example;

import com.beamofsoul.test.demo.model.NacosConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过自动装备获取配置文件中自动刷新的内容
 */
@RestController
@RequestMapping("/nacos/bean")
public class BeanAutoRefreshConfigExample {

    @Autowired
    private NacosConfigInfo nacosConfigInfo;

    // http://localhost:8079/nacos/bean
    @GetMapping
    public Map<String, String> getConfigInfo() {
        System.out.println("# " + System.getProperty("namespace"));
        return new HashMap<String, String>() {{
            put("serverAddr", nacosConfigInfo.getServerAddr());
            put("prefix", nacosConfigInfo.getPrefix());
            put("group", nacosConfigInfo.getGroup());
            put("namespace", nacosConfigInfo.getNamespace());
        }};
    }
}
