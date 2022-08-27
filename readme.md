## Readme 阅读信息

### 启动命令
- Nacos Server
```shell script
F:/Soft/nacos/bin/startup.cmd -m standalone # Nacos Server
```
- Sentinel Dashboard
```shell script
java ^
-Dserver.port=8080 ^
-Dcsp.sentinel.dashboard.server=localhost:8080 ^
-Dproject.name=sentinel-dashboard ^
-Dself.nacos.server.addr=localhost:8848 ^
-Dself.dataId.postfix=-flow ^
-Dself.groupId=DEFAULT_GROUP ^
-Dself.gateway.api.dataId.postfix=-apis ^
-Dself.gateway.api.groupId=DEFAULT_GROUP ^
-Dself.gateway.flow.dataId.postfix=-sentinel ^
-Dself.gateway.flow.groupId=DEFAULT_GROUP ^
-Dself.degrade.dataId.postfix=-degrade ^
-Dself.degrade.groupId=DEFAULT_GROUP ^
-jar F:/Soft/SentinelDashboard/sentinel-dashboard-1.8.5-self.jar
```
### 访问记录
[Nacos console](http://localhost:8848/nacos/index.html) \
[Sentinel dashboard](http://localhost:8080/index.html) \
[Gateway flow control by sentinel test](http://localhost:8999/nacos/flow/index.html) \
[Web flow control by sentinel through gateway test](http://localhost:8999/nacos/internal/justin/index.html) \
[Web flow control by sentinel test](http://localhost:8081/echo/abc/index.html)
### 构建过程
#### 1. Nacos Discovery
[最佳实践](https://github.com/alibaba/spring-cloud-alibaba/tree/2.2.x/spring-cloud-alibaba-examples/nacos-example/nacos-discovery-example) \
service-provider \
service-consumer \
provider-consumer-api
#### 2. Nacos Config
[官方文档](https://spring-cloud-alibaba-group.github.io/github-pages/2021/en-us/index.html) \
[最佳实践](https://github.com/alibaba/spring-cloud-alibaba/tree/2.2.x/spring-cloud-alibaba-examples/nacos-example/nacos-config-example) \
nacos-config
#### 3. Gateway
[最佳实践](https://github.com/alibaba/spring-cloud-alibaba/tree/2.2.x/spring-cloud-alibaba-examples/nacos-example/nacos-gateway-example) \
service-gateway \
service-gateway-provider \
service-provider
#### 4. Sentinel
[参考资料1](https://blog.51cto.com/u_15491961/5089243) \
[参考资料2](https://blog.csdn.net/zhuocailing3390/article/details/123246011) \
[参考资料3](https://blog.csdn.net/apple_csdn/article/details/123364914) \
[参考资料4 - Sentinel使用Nacos存储规则及同步(应用)](https://blog.csdn.net/a1036645146/article/details/107844149) \
[参考资料5 - Sentinel使用Nacos存储规则及同步(网关)](https://blog.csdn.net/m0_47333020/article/details/121410210) \
[参考资料6 - Sentinel接入网关 自定义异常(网关)](https://zhuanlan.zhihu.com/p/363941009) \
[参考资料7 - 生产实践：Sentinel 进阶应用场景(熔断、降级)](https://blog.csdn.net/vincent_wen0766/article/details/121951546) \
[参考资料8 - Sentinel限流熔断](https://blog.csdn.net/qq_45932374/article/details/122122786) \
[参考资料9 - 将 Sentinel 熔断限流规则持久化到 Nacos 配置中心](https://www.jianshu.com/p/44485acd178e) \
[参考资料10- Sentinel基础使用-限流降级熔断(应用自定义异常)](http://events.jianshu.io/p/3390200493c9) \
service-gateway \
service-gateway-provider \
serivce-provider
#### 5. Upgraded to Spring Cloud 2021.0.1, Spring Cloud 2021.0.1.0, Spring Boot 2.7.3
[参考资料1 - Spring Cloud 版本依赖关系](https://github.com/spring-cloud/spring-cloud-release/wiki/Supported-Versions) \
[参考资料2 - Spring Cloud Aliabab 毕业版本依赖关系(推荐使用)](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E) \
[参考资料3 - 升级Spring Cloud Alibaba 2021.1，Spring Cloud 2020.0.1，Spring Boot 2.4.2碰到的一系列兼容性问题及解决方案](https://blog.csdn.net/Tuine/article/details/122153363)
#### 6. gRPC (RPC)
https://blog.csdn.net/asdcls/article/details/121661651
https://blog.csdn.net/qq_21046665/article/details/120722942
https://spring.io/blog/2021/12/08/spring-cloud-gateway-and-grpc
[参考资料1 - gRPC-Web Spring Cloud Gateway](https://javarepos.com/lib/yuanyouxi-grpc-web-spring-cloud-gateway) \
[参考资料2 - SpringCloud Alibaba实战(12：引入Dubbo实现RPC调用)](https://www.cnblogs.com/three-fighter/p/15721685.html)

## Nacos Config 持久化信息

**_<u> namespace - public </u>_**

#### 1. nacos-config.yaml 配置中心基础配置，可在main函数中输出
```yaml
user:
    name: nacos-config.yaml-updates
    age: 68
    gender: male
```
#### 2. data-source.yaml 数据库配置，可通过@PropertiesConfiguration获取
```yaml
spring:
  datasource:
    name: datasource
    url: jdbc:mysql://127.0.0.1:3306/nacos?characterEncoding=UTF-8&characterSetResults=UTF-8&zeroDateTimeBehavior=convertToNull&useDynamicCharsetInfo=false&useSSL=false
    username: root1
    password: root1
    driverClassName: com.mysql.jdbc.Driver
```
#### 3. ext-data-source.yaml 数据库额外配置，可覆盖原有数据库配置，有更高优先级
```yaml
spring:
    datasource:
     username: ext-root
     password: ext-root
```
#### 4. service-gateway.yaml 网管配置
```yaml
spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
      loadbalancer:
        use404: true # when a service instance cannot be found, from 503 to 404
      routes:
      - id: gateway-provider-route
        uri: lb://service-gateway-provider
        predicates:
          - Path=/nacos/**
        filters:
          - StripPrefix=1
      - id: v1-route
        uri: lb://service-provider
        predicates:
          - Path=/v1/**
        filters:
          - StripPrefix=1
```
#### 5. service-gateway-sentinel 网关限流所用针对API分组的限流配置
```json5
[
  {
    "app": "service-gateway",
    "burst": 0, // 额外裂解数量，除限制外增加数量
    "controlBehavior": 0, // 控流方式，0快速失败，2匀速排队
    "count": 1, // QPS阈值
    "gmtModified": 1661333784075,
    "grade": 1, // 阈值类型，0线程数，1QPS
    "id": 13,
    "interval": 5, // 间隔时间
    "intervalUnit": 0, // 时间单位，0秒，1分，2时，3天
    "ip": "192.168.238.1",
    "port": 8720,
    "resource": "flow-api",
    "resourceMode": 1 // API类型，0RouteId, 1API分组
  },
  {
    "app": "service-gateway",
    "burst": 0,
    "controlBehavior": 0,
    "count": 1,
    "gmtModified": 1661333823589,
    "grade": 1,
    "id": 14,
    "interval": 3,
    "intervalUnit": 0,
    "ip": "192.168.238.1",
    "port": 8720,
    "resource": "gateway-provider-api",
    "resourceMode": 1
  }
]
```
#### 6. service-gateway-apis 网关限流所用API分组定义
```json
[{
    "apiName": "flow-api",
    "predicateItems": [
        {
            "matchStrategy": 0,
            "pattern": "/nacos/flow"
        }
    ]
}]
```
#### 7. service-provider-flow 应用限流配置
```json
[
    {
    	"app":"service-provider",
        "resource": "/echo/{string}",
        "count": 1,
        "grade": 1,
        "limitApp": "default",
        "strategy": 0,
        "controlBehavior": 0
    }
]
```
#### 8. service-gateway-degrade 网关熔断降级配置
```json5
[{
	"app": "service-gateway",
	"count": 1000.0,
	"gmtCreate": 1661423849388,
	"gmtModified": 1661423849388,
	"grade": 0, // 熔断策略，0慢调用比例，1异常比例，2异常数
	"id": 8,
	"ip": "192.168.238.1",
	"limitApp": "default",
	"minRequestAmount": 1, // 熔断触发的最小请求数
	"port": 8720,
	"resource": "degrade-api", // 资源名，API分组
	"slowRatioThreshold": 1.0, // 慢调用比例阈值，仅慢调用比例模式有效，如0.1意味10%，10%的请求在这段时间出现慢调用情况
	"statIntervalMs": 1000, // 统计时长，单位毫秒
	"timeWindow": 10 // 熔断时长，单位秒
}]
```