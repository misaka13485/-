package com.zengxuan.gateway.filter;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
@ComponentScan
@Order(1)
public class LogFilter implements WebFilter {

    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("请求地址: {}", request.getURI());
        log.info("请求方式: {}", request.getMethodValue());
        log.info("请求头: {}", request.getHeaders());
        log.info("请求参数: {}", request.getQueryParams());
        log.info("请求体: {}", request.getBody());
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpResponseDecorator responseDecorator = new ServerHttpResponseDecorator(response) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                return super.writeWith(body);
            }
        };
        return chain.filter(exchange.mutate().response(responseDecorator).build());
    }
}
//}
//@Order(1)
//
//public class LogFilter implements WebFilter {
//    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);
//    public static final String B = "B";
//    public static final String KB = "KB";
//    public static final String MS = "ms";
//    public static final int SIZE = 1024;
//    public static final String TEMPLATE = "%s %s %s %s %s";
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        long begin = System.currentTimeMillis();
//        String uri = request.getURI().getPath();
//        ServerHttpResponse originalResponse = exchange.getResponse();
//        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
//            @Override
//            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
//                if (body instanceof Flux) {
//                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
//                    return super.writeWith(fluxBody.map(dataBuffer -> {
//                        long end = System.currentTimeMillis();
//                        int length = dataBuffer.readableByteCount();
//                        String newLength;
//                        if (length < SIZE) {
//                            newLength = length + B;
//                        } else {
//                            newLength = length / SIZE + KB;
//                        }
//                        logger.info(String.format(TEMPLATE, request.getMethod().name(), uri, (end - begin) + MS, originalResponse.getStatusCode().value(), newLength));
//                        return dataBuffer;
//                    }));
//                }
//                // if body is not a flux. never got there.
//                return super.writeWith(body);
//            }
//        };
//        return chain.filter(exchange.mutate().response(decoratedResponse).build());
//    }
//
//}