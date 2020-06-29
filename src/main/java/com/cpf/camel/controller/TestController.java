package com.cpf.camel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者：caopengfei
 * @时间：2020/6/29
 */
@RequestMapping("hello")
@RestController
public class TestController {

    @GetMapping("/say/{message}")
    public String getHello(@PathVariable(name ="message" ) String message){
        return "i say "+message;
    }

}
