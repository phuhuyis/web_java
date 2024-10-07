package com.example.websiteqa.controller.admin;

import com.example.websiteqa.model.Loaisanpham;
import com.example.websiteqa.model.Nhanhieu;
import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.NhanHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller(value = "loaiSanPhamAdmin")
@RequestMapping("/admin/loaisanpham")
public class LoaiSanPhamController {
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("listLoaiSanPham", loaiSanPhamService.list());
        model.addAttribute("title", "Quản lý loại sản phẩm");
        model.addAttribute("active", "loaisanpham");
        return "admin/loaisanpham/list";
    }

    @GetMapping({"/create"})
    public String create(@ModelAttribute(name = "loaisanpham") Loaisanpham loaisanpham, Model model){
        model.addAttribute("title", "Quản lý loại sản phẩm");
        model.addAttribute("active", "loaisanpham");
        return "admin/loaisanpham/create";
    }

    @PostMapping({"/create"})
    public String create(@Valid @ModelAttribute(name = "loaisanpham")Loaisanpham loaisanpham, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Quản lý loại sản phẩm");
        model.addAttribute("active", "loaisanpham");
        if(!bindingResult.hasErrors()){
            if(loaiSanPhamService.isExistDuongDan(loaisanpham.getDuongdan())){
                model.addAttribute("error", "Đường dẫn đã tồn tại");
            }else{
                model.addAttribute("success", "Thêm loại sản phẩm thành công");
                loaiSanPhamService.add(loaisanpham);
            }
        }
        return "admin/loaisanpham/create";
    }

    @GetMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("title", "Quản lý loại sản phẩm");
        model.addAttribute("active", "loaisanpham");
        model.addAttribute("loaisanpham", loaiSanPhamService.get(id));
        return "admin/loaisanpham/edit";
    }

    @PostMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, @Valid @ModelAttribute(name = "loaisanpham")Loaisanpham loaisanpham, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Quản lý loại sản phẩm");
        model.addAttribute("active", "loaisanpham");
        if(!bindingResult.hasErrors()){
            if(loaiSanPhamService.isExistDuongDan(loaisanpham.getDuongdan())){
                model.addAttribute("error", "Đường dẫn đã tồn tại");
            }else{
                model.addAttribute("success", "Cập nhập loại sản phẩm thành công");
                loaiSanPhamService.update(loaisanpham);
            }
        }
        return "admin/loaisanpham/edit";
    }
}
