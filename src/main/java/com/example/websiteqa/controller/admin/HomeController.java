package com.example.websiteqa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminHome")
@RequestMapping("/admin")
public class HomeController {
    @GetMapping({"", "/home"})
    public String home(){
        return "redirect:/admin/report";
    }
}