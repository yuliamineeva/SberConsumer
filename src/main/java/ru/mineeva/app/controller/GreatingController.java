package ru.mineeva.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreatingController {

    @GetMapping("/")
    public String sayHello() {
        return "index";
    }
}
