package com.example.websiteqa.controller.client;

import com.example.websiteqa.model.Sanpham;
import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.NhanHieuService;
import com.example.websiteqa.service.SanPhamService;
import com.example.websiteqa.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller(value = "webHome")
public class HomeController {
    @Autowired
    private NhanHieuService nhanHieuService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    @Autowired
    private SlideService slideService;
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping({"", "/home"})
    public String home(Model model){
        model.addAttribute("title", "Phonmixay Shop - Chuyên cung cấp các sản phẩm thời gian chất lượng");
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        model.addAttribute("slides", slideService.list());
        List<Sanpham> products = sanPhamService.list();
        int size = products.size();
        for (int i = 8; i < size; i++)
            products.remove(0);
        model.addAttribute("products", products);
        model.addAttribute("allProduct", sanPhamService.list());
        model.addAttribute("active", "home");
        return "client/home";
    }
}
