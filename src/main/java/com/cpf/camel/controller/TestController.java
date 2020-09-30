package com.cpf.camel.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @作者：caopengfei
 * @时间：2020/6/29
 */
@RequestMapping("hello")
@RestController
public class TestController {

    @GetMapping("/say/{message}")
    public String getHello(@PathVariable(name = "message") String message) {
        return "i say " + message;
    }

    @PostMapping("/say/{message}")
    public String getPostHello(@PathVariable(name = "message") String message) {
        return "i say post" + message;
    }

}
