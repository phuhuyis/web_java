package com.example.websiteqa.controller.client;

import com.example.websiteqa.model.Khachhang;
import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.NhanHieuService;
import com.example.websiteqa.service.TaiKhoanService;
import com.example.websiteqa.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private NhanHieuService nhanHieuService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping({""})
    public String index(Model model, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return "redirect:/login";
        Khachhang khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername());
        model.addAttribute("khachhang", khachhang);
        model.addAttribute("title", "Cập nhập tài khoản");
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        return "client/account/edit";
    }

    @PostMapping({""})
    public String index(Model model,
                        @Valid @ModelAttribute(name = "khachhang") Khachhang khachhang,
                        BindingResult bindingResult,
                        HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return "redirect:/login";
        model.addAttribute("title", "Cập nhập tài khoản");
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        if(!(bindingResult.hasFieldErrors("hovaten")
                || bindingResult.hasFieldErrors("diachi")
                || bindingResult.hasFieldErrors("sdt")
                || bindingResult.hasFieldErrors("password"))){
            model.addAttribute("success", "Cập nhập tài khoản thành công");
            khachhang.setUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername());
            khachHangService.updateAccount(khachhang);
        }
        return "client/account/edit";
    }
}
