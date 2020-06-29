package com.cpf.camel.demo.hystraix;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * @作者：caopengfei
 * @时间：2020/6/28
 */
public class RestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("jetty").host("localhost").port(8888).bindingMode(RestBindingMode.auto);
        rest("/hello").get("/say/{message}").route().toD("http4://127.0.0.1:8080?bridgeEndpoint=true");
    }
}
