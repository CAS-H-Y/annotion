package com.heyang.controller;

import com.heyang.annotion.myannotion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: annotion
 * @Package: com.heyang.controller
 * @Description: java类作用描述
 * @Author: heyang
 * @CreateDate: 2019/6/16 12:12
 */
@RestController
@RequestMapping("/v1")
public class UserController {

    @myannotion(type="1")
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") String id ){
        return "1";
    }
}
