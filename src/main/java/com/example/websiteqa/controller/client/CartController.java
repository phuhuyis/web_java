package com.example.websiteqa.controller.client;

import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.*;
import com.example.websiteqa.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private NhanHieuService nhanHieuService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping({""})
    public String home(Model model, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return "redirect:/login";
        model.addAttribute("title", "Giỏ hàng");
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        int khachhang = khachHangService.getByUsername(((Taikhoan) SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        model.addAttribute("carts", gioHangService.listByKhachHang(khachhang));
        model.addAttribute("products", sanPhamService.list());
        return "client/cart/index";
    }
}
