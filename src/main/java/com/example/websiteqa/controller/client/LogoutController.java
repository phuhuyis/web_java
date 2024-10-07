package com.example.websiteqa.controller.client;

import com.example.websiteqa.utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "logoutController")
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping({""})
    public String index(HttpServletRequest request){
        SessionUtil.getInstance().delKey(request, "user");
        return "redirect:";
    }
}
