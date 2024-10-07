package com.example.websiteqa.controller.admin;

import com.example.websiteqa.model.Nhanhieu;
import com.example.websiteqa.model.Sanpham;
import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.NhanHieuService;
import com.example.websiteqa.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller(value = "sanPhamAdmin")
@RequestMapping("/admin/sanpham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    @Autowired
    private NhanHieuService nhanHieuService;

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("listSanPham", sanPhamService.list());
        model.addAttribute("title", "Quản lý sản phẩm");
        model.addAttribute("active", "sanpham");
        return "admin/sanpham/list";
    }

    @GetMapping({"/create"})
    public String create(@ModelAttribute(name = "sanpham") Sanpham sanpham, Model model){
        model.addAttribute("title", "Thêm sản phẩm");
        model.addAttribute("active", "sanpham");
        model.addAttribute("danhmucs", loaiSanPhamService.list());
        model.addAttribute("nhanhieus", nhanHieuService.list());
        return "admin/sanpham/create";
    }

    @PostMapping({"/create"})
    public String create(@Valid @ModelAttribute(name = "sanpham")Sanpham sanpham, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Thêm sản phẩm");
        model.addAttribute("active", "sanpham");
        model.addAttribute("danhmucs", loaiSanPhamService.list());
        model.addAttribute("nhanhieus", nhanHieuService.list());
        if(!bindingResult.hasErrors()){
            if(!sanPhamService.checkFile(sanpham.getFile())){
                model.addAttribute("error", "Chưa chọn hình ảnh hoặc file hình ảnh không hợp lệ chỉ nhận định dạng jpg, png, jpeg");
            }else{
                model.addAttribute("success", "Thêm sản phẩm thành công");
                sanPhamService.add(sanpham);
            }
        }
        return "admin/sanpham/create";
    }

    @GetMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("title", "Cập nhập sản phẩm");
        model.addAttribute("active", "sanpham");
        model.addAttribute("danhmucs", loaiSanPhamService.list());
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("sanpham", sanPhamService.get(id));
        return "admin/sanpham/edit";
    }

    @PostMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, @Valid @ModelAttribute(name = "sanpham")Sanpham sanpham, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Cập nhập sản phẩm");
        model.addAttribute("active", "sanpham");
        model.addAttribute("danhmucs", loaiSanPhamService.list());
        model.addAttribute("nhanhieus", nhanHieuService.list());
        if(!bindingResult.hasErrors()){
            if(!sanPhamService.checkFile(sanpham.getFile())){
                model.addAttribute("error", "Chưa chọn hình ảnh hoặc file hình ảnh không hợp lệ chỉ nhận định dạng jpg, png, jpeg");
            }else{
                model.addAttribute("success", "Cập nhập sản phẩm thành công");
                try {
                    sanPhamService.update(sanpham);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return "admin/sanpham/edit";
    }
}
