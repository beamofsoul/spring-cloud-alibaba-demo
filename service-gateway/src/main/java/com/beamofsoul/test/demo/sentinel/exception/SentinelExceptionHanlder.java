//package com.beamofsoul.test.demo.sentinel.exception;
//
//import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
//import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
//import com.alibaba.fastjson.JSON;
//import org.apache.http.entity.ContentType;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.codec.ServerCodecConfigurer;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.web.reactive.result.view.ViewResolver;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//public class SentinelExceptionHanlder extends SentinelGatewayBlockExceptionHandler {
//
//    public SentinelExceptionHanlder(List<ViewResolver> viewResolvers, ServerCodecConfigurer serverCodecConfigurer) {
//        super(viewResolvers, serverCodecConfigurer);
//    }
//
//    @Override
//    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
//        final int code = 1500;
//        String message = ex instanceof FlowException ? "请求被限流" :
//                ex instanceof ParamFlowException ? "请求被热点参数限流" :
//                        ex instanceof DegradeException ? "请求被降级" :
//                                ex instanceof AuthorityException ? "没有权限访问" : "未知异常";
//        SentinelResponseEntity sre = SentinelResponseEntity.builder().code(code).message(message).build();
//        ServerHttpResponse serverHttpResponse = exchange.getResponse();
//        serverHttpResponse.getHeaders().add("Content-Type", ContentType.APPLICATION_JSON.toString());
//        byte[] datas = JSON.toJSONString(sre).getBytes(StandardCharsets.UTF_8);
//        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(datas);
//        return serverHttpResponse.writeWith(Mono.just(buffer));
//    }
//}
