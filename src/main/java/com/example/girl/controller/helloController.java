package com.example.girl.controller;

import com.example.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class helloController {
    @Autowired
    private GirlProperties girlProperties;

    //  @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "path", required = false, defaultValue = "错误：你参数忘记传了") String id) {
        return "path:" + id;

        // return girlProperties.getCupSize();
    }
}
