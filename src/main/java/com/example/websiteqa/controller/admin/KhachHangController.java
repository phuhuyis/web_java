package com.example.websiteqa.controller.admin;

import com.example.websiteqa.model.Khachhang;
import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller(value = "khachHangAdmin")
@RequestMapping("/admin/khachhang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("listKhachHang", khachHangService.list());
        model.addAttribute("title", "Quản lý khách hàng");
        model.addAttribute("active", "khachhang");
        return "admin/khachhang/list";
    }

    @GetMapping({"/create"})
    public String create(@ModelAttribute(name = "khachhang") Khachhang khachhang, Model model){
        model.addAttribute("title", "Thêm khách hàng");
        model.addAttribute("active", "khachhang");
        return "admin/khachhang/create";
    }

    @PostMapping({"/create"})
    public String create(@Valid @ModelAttribute(name = "khachhang")Khachhang khachhang, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Thêm khách hàng");
        model.addAttribute("active", "khachhang");
        if(!bindingResult.hasErrors()){
            if(taiKhoanService.isExistUsername(khachhang.getUsername())){
                model.addAttribute("error", "Tài khoản đã tồn tại");
            }else{
                model.addAttribute("success", "Thêm khách hàng thành công");
                khachHangService.add(khachhang);
            }
        }
        return "admin/khachhang/create";
    }

    @GetMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("title", "Cập nhập khách hàng");
        model.addAttribute("active", "khachhang");
        model.addAttribute("khachhang", khachHangService.get(id));
        return "admin/khachhang/edit";
    }

    @PostMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, @Valid @ModelAttribute(name = "khachhang")Khachhang khachhang, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Cập nhập khách hàng");
        model.addAttribute("active", "khachhang");
        if(!(bindingResult.hasFieldErrors("hovaten")
                || bindingResult.hasFieldErrors("diachi")
                || bindingResult.hasFieldErrors("sdt"))){
            model.addAttribute("success", "Cập nhập khách hàng thành công");
            khachHangService.update(khachhang);
        }
        return "admin/khachhang/edit";
    }
}
