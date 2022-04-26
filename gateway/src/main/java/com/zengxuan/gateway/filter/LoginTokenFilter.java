package com.zengxuan.gateway.filter;



import com.zengxuan.gateway.entity.User;
import com.zengxuan.gateway.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


/**
 * @author denny
 * @Description token过滤器
 * @date 2019/12/12 13:55
 */
@Configuration
@Order(3)
@Slf4j
public class LoginTokenFilter implements WebFilter {


    private static final String AUTHORIZE_TOKEN = "Authorization";
    private static final String BEARER = "Bearer ";
    private static final String[] IGNORE_URI = {"(.*)/swagger-resources/(.*)", "/(.*)/webjars/(.*)", "/(.*)/v2/(.*)", "/(.*)/swagger-ui.html/(.*)", "/(.*)/favicon.ico"};
    private static final String[] IGNORE_URI_PREFIX = {"/auth", "/test", "/swagger-resources", "/webjars", "/v2", "/swagger-ui.html", "/favicon.ico", "/null"};

    /**
     * token过滤
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("当前环境已开启token校验");
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        ServerHttpResponse response = exchange.getResponse();
        //获取path
        String path = request.getURI().getPath();
        log.info("当前请求的Path:{}",path);
        //Path白名单过滤
        for ( String uri : IGNORE_URI_PREFIX) {
            if(path.startsWith(uri)){
                log.info("当前请求的Path:{}位于白名单，跳过验证",path);
                return chain.filter(exchange);
            }

        }
        for (String uri : IGNORE_URI) {
            if (path.matches(uri)) {
                log.info("当前请求的Path:{}位于白名单，跳过验证",path);
                return chain.filter(exchange);
            }
        }


        // 取Authorization
        String tokenHeader = headers.getFirst(AUTHORIZE_TOKEN);
        log.info("tokenHeader=" + tokenHeader);

        // token不存在
        if (StringUtils.isEmpty(tokenHeader)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            log.info("token不存在，请求拒绝");
            return response.setComplete();
        }
        // 取token
        String token = this.getToken(tokenHeader);
        log.info("token=" + token);

        // token不存在
        if (StringUtils.isEmpty(token)) {
            log.info("token不存在，请求拒绝");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 校验 token是否失效
        // 校验 token是否正确
        TokenUtils tokenUtils = new TokenUtils();
        User user = tokenUtils.verify(token);

        if (user.getUsername() == null) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //将用户信息装入请求头
        headers.add("username",user.getUsername());
        headers.add("id",user.getId());




        //有token 这里可根据具体情况，看是否需要在gateway直接把解析出来的用户信息塞进请求中，我们最终没有使用
//        UserTokenInfo userTokenInfo = UserTokenTools.getUserTokenInfo(token);
//        log.info("token={},userTokenInfo={}",token,userTokenInfo);
//        request.getQueryParams().add("token",token);
//        request.getHeaders().set("token", token);
        return chain.filter(exchange);
    }

    /**
     * 解析Token
     */
    public String getToken(String requestHeader) {
        //2.Cookie中没有从header中获取
        if (requestHeader != null && requestHeader.startsWith(BEARER)) {
            return requestHeader.substring(7);
        }
        return "";
    }

//    @Override
//    public int getOrder() {
//        return -10;
//    }


}