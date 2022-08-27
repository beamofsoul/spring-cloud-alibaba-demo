//package com.beamofsoul.test.demo.sentinel.exception;
//
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.codec.ServerCodecConfigurer;
//import org.springframework.web.reactive.result.view.ViewResolver;
//
//import java.util.Collections;
//import java.util.List;
//
//@Configuration
//public class SentinelExceptionConfiguration {
//
//    private final List<ViewResolver> viewResolvers;
//    private final ServerCodecConfigurer serverCodecConfigurer;
//
//    public SentinelExceptionConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider, ServerCodecConfigurer serverCodecConfigurer) {
//        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
//        this.serverCodecConfigurer = serverCodecConfigurer;
//    }
//
//    /**
//     * Register the block exception handler for Spring Cloud Gateway.
//     */
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public SentinelExceptionHanlder sentinelGatewayExceptionHandler() {
//        return new SentinelExceptionHanlder(viewResolvers, serverCodecConfigurer);
//    }
//}
