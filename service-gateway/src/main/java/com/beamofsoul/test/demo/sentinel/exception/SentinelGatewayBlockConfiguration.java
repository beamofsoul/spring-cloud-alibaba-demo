package com.beamofsoul.test.demo.sentinel.exception;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Configuration
public class SentinelGatewayBlockConfiguration {

    @Bean
    public BlockRequestHandler blockRequestHandler() {
        return (exchange, t) -> ServerResponse.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromValue(getBlockedResponseEntity(t)));
    }

    private static SentinelResponseEntity getBlockedResponseEntity(final Throwable t) {
        int code;
        String message;
        if (t instanceof FlowException) {
            code = 1501;
            message = "请求被限流";
        } else if (t instanceof ParamFlowException) {
            code = 1502;
            message = "请求被热点参数限流";
        } else if (t instanceof DegradeException) {
            code = 1503;
            message = "请求被降级";
        } else if (t instanceof AuthorityException) {
            code = 1504;
            message = "没有权限访问";
        } else {
            code = 1500;
            message = "未知异常";
        }
        return SentinelResponseEntity.builder().code(code).message(message).build();
    }
}
