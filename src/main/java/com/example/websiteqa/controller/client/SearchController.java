package com.example.websiteqa.controller.client;

import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.NhanHieuService;
import com.example.websiteqa.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    @Autowired
    private NhanHieuService nhanHieuService;

    @GetMapping({""})
    public String index(HttpServletRequest request, Model model){
        String keyWord = request.getParameter("keyWord");
        Integer page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        model.addAttribute("title", "Tìm kiếm \"" + keyWord + "\"");
        model.addAttribute("brands", nhanHieuService.list());
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        model.addAttribute("products", sanPhamService.searchByKeyWord(keyWord, page));
        model.addAttribute("fullPage", sanPhamService.getFullPageByKeyWord(keyWord));
        model.addAttribute("page", page);
        model.addAttribute("keyWord", keyWord);
        return "client/search/index";
    }
}
