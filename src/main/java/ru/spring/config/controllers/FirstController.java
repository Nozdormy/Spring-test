package ru.spring.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }


    // @RequestParam Используется только если переменный не null иначе будет ошибка
    // Или пишем так @RequestParam (value = "name", required = false)
    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam (value = "name", required = false) String name,
                              @RequestParam String surname) {
        System.out.println("Hello " + name + " " + surname);
        return "first/goodbye";
    }
}
