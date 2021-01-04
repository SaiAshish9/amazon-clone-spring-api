package com.amazon.springapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// username -> user password -> obtain from terminal

@RestController
@RequestMapping("/")
public class hello {

    @GetMapping
    public Map<String, String> getMsg() {
        HashMap msg = new HashMap();
        msg.put("msg", "hi, sai this side");
        return msg;
    }

}
