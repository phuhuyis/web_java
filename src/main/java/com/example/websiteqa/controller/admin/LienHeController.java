package com.example.websiteqa.controller.admin;

import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.service.LienHeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller(value = "lienheAdmin")
@RequestMapping("/admin/lienhe")
public class LienHeController {
    @Autowired
    private LienHeService lienHeService;
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("listLienHe", lienHeService.list());
        model.addAttribute("listKhachHang", khachHangService.list());
        model.addAttribute("title", "Quản lý liên hệ");
        model.addAttribute("active", "lienhe");
        return "admin/lienhe/list";
    }
}
