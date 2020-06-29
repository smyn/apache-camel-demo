package com.cpf.camel.demo.hystraix;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @作者：caopengfei
 * @时间：2020/5/28
 */
public class FallbackProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getOut().setBody("服务熔断");
    }
}
