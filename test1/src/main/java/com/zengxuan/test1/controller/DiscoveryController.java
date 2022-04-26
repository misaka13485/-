
// Refer to document: https://github.com/nacos-group/nacos-examples/tree/master/nacos-spring-example/nacos-spring-discovery-example/src/main/java/com/alibaba/nacos/example/spring/controller
package com.zengxuan.test1.controller;

import org.apache.http.impl.bootstrap.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DiscoveryController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping(value = "**")
    public String get(){



        return httpServletRequest.getRequestURL().toString();
    }
}