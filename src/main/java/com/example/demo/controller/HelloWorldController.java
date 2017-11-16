package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * first
 *
 * @author wzm
 * @create 2017-11-16-11:02
 */
//RestController:controller里面的方法都以json格式输出，不用再写什么jackjson配置的了
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }
}
