package ru.spring.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello " + name + " " + surname);
        System.out.println(model);
        return "first/hello";
    }


    // @RequestParam String name -  Используется только если переменный не null иначе будет ошибка
    // Или пишем так @RequestParam (value = "name", required = false)
    @GetMapping("/goodbye")
    public String goodbyePage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {

        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = (double) a / b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            default:
                result = 0;
                System.out.println("ERROR");
                break;
        }

        model.addAttribute("result", result);
        
        return "first/calculator";
    }
}
