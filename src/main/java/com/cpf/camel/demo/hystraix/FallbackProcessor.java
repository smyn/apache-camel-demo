package com.cpf.camel.demo.hystraix;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @作者：caopengfei
 * @时间：2020/5/28
 */
@Slf4j
public class FallbackProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        log.info(exchange.getIn().getHeader("sdfsdf") + "");
    }
}
