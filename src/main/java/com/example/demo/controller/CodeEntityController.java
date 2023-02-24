package com.example.demo.controller;

import com.example.demo.service.CodeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class CodeEntityController {

    @Autowired
    private CodeEntityService entityService;

    @GetMapping
    public String nextCode() {
        return "{\"code\": \" " + entityService.nextCode() + "\" }";
    }
}
