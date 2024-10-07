package com.example.websiteqa.controller.client;

import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.NhanHieuService;
import com.example.websiteqa.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    @Autowired
    private NhanHieuService nhanHieuService;

    @GetMapping({"/{metatitle}/{page}", "/{metatitle}"})
    public String index(@PathVariable(name = "metatitle")String metatitle,
                        @PathVariable(name = "page", required = false)Integer page, HttpServletRequest request, Model model){
        if(page == null)
            page = 1;
        model.addAttribute("title", nhanHieuService.getByMetatitle(metatitle).getTen());
        model.addAttribute("active", "brand");
        model.addAttribute("brands", nhanHieuService.list());
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        model.addAttribute("products", sanPhamService.searchByBrand(metatitle, page));
        model.addAttribute("fullPage", sanPhamService.getFullPageByBrand(metatitle));
        model.addAttribute("page", page);
        model.addAttribute("metatitle", metatitle);
        return "client/brand/index";
    }
}
