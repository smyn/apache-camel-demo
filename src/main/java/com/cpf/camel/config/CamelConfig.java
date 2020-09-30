package com.cpf.camel.config;

import com.cpf.camel.demo.hystraix.HystrixRoute;
import com.cpf.camel.demo.hystraix.RestRoute;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @作者： caopengfei
 * @时间： 2019/5/15
 */
@Configuration
public class CamelConfig {

    @Autowired
    CamelContext camelContext;


    @Bean
    ArrayList startRoute() throws Exception {
//        camelContext.addRoutes(new HystrixRoute());
//        camelContext.addRoutes(new RestRoute());
        return new ArrayList();
    }
}
