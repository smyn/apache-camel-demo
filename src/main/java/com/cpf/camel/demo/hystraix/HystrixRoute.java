package com.cpf.camel.demo.hystraix;
import org.apache.camel.builder.RouteBuilder;

/**
 * @作者：caopengfei
 * @时间：2020/5/28
 */

public class HystrixRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        onException(Exception.class).handled(true).process(new FallbackProcessor());
        from("jetty:http://0.0.0.0:9998/getToken").to("http4://127.0.0.1:8081/hsb/testDemo/serviceList?bridgeEndpoint=true" +
                "&httpClient.connectTimeout="+(1000)+
                "&httpClient.socketTimeout="+(1000)+
                "&httpClient.connectionRequestTimeout="+(1000)+
                "&keepAlive=true");
/*
        from("jetty:http://0.0.0.0:9998/getToken")
                .hystrix()
                // use 2 second timeout
                .hystrixConfiguration().executionTimeoutInMilliseconds(2000).end()
                .toD("direct:slow")
                .onFallback()
                .transform().constant("Fallback response")
                .end();


         from("direct:slow").to("http4://127.0.0.1:8081/hsb/testDemo/serviceList?bridgeEndpoint=true" +
                        "&httpClient.connectTimeout="+(10*1000)+
                        "&httpClient.socketTimeout="+(10*1000)+
                        "&httpClient.connectionRequestTimeout="+(10*1000)+
                        "&keepAlive=true");
*/

/*        from("jetty:http://0.0.0.0:9998/getToken")
                .hystrix()
                .hystrixConfiguration().executionTimeoutInMilliseconds(2000).end()
                .log("Hystrix processing start: ${threadName}")
                .toD("direct:${body}")
                .onFallback()
                .log("Hystrix fallback start: ${threadName}")
                .transform().constant("Fallback response")
                .log("Hystrix fallback end: ${threadName}")
                .end()
                .log("After Hystrix ${body}");*/

/*
        from("direct:fast")// .transform().constant("Slow response")
               .to("http4://127.0.0.1:8081/hsb/testDemo/serviceList?bridgeEndpoint=true" +
                "&httpClient.connectTimeout="+(10*1000)+
                "&httpClient.socketTimeout="+(10*1000)+
                "&httpClient.connectionRequestTimeout="+(10*1000)+
                "&keepAlive=true");
*/

/*        from("direct:fast")
                // this is a fast route and takes 1 second to respond
                .log("Fast processing start: ${threadName}")
                .delay(3000)
                .transform().constant("Fast response")
                .log("Fast processing end: ${threadName}");*/

    }
}
