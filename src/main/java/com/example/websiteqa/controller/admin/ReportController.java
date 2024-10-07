package com.example.websiteqa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/report")
public class ReportController {

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("title", "Báo cáo/thống kê");
        model.addAttribute("active", "report");
        return "admin/report/index";
    }
}
