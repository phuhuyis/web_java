package com.example.websiteqa.controller.admin;

import com.example.websiteqa.model.Nhanhieu;
import com.example.websiteqa.service.NhanHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller(value = "nhanHieuAdmin")
@RequestMapping("/admin/nhanhieu")
public class NhanHieuController {
    @Autowired
    private NhanHieuService nhanHieuService;

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("listNhanHieu", nhanHieuService.list());
        model.addAttribute("title", "Quản lý nhãn hiệu");
        model.addAttribute("active", "nhanhieu");
        return "admin/nhanhieu/list";
    }

    @GetMapping({"/create"})
    public String create(@ModelAttribute(name = "nhanhieu")Nhanhieu nhanhieu, Model model){
        model.addAttribute("title", "Thêm nhãn hiệu");
        model.addAttribute("active", "nhanhieu");
        return "admin/nhanhieu/create";
    }

    @PostMapping({"/create"})
    public String create(@Valid @ModelAttribute(name = "nhanhieu")Nhanhieu nhanhieu, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Thêm nhãn hiệu");
        model.addAttribute("active", "nhanhieu");
        if(!bindingResult.hasErrors()){
            if(nhanHieuService.isExistDuongDan(nhanhieu.getDuongdan())){
                model.addAttribute("error", "Đường dẫn đã tồn tại");
            }else{
                model.addAttribute("success", "Thêm nhãn hiệu thành công");
                nhanHieuService.add(nhanhieu);
            }
        }
        return "admin/nhanhieu/create";
    }

    @GetMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("title", "Cập nhập nhãn hiệu");
        model.addAttribute("active", "nhanhieu");
        model.addAttribute("nhanhieu", nhanHieuService.get(id));
        return "admin/nhanhieu/edit";
    }

    @PostMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, @Valid @ModelAttribute(name = "nhanhieu")Nhanhieu nhanhieu, BindingResult bindingResult, Model model){
        model.addAttribute("title", "Cập nhập nhãn hiệu");
        model.addAttribute("active", "nhanhieu");
        if(!bindingResult.hasErrors()){
            if(nhanHieuService.isExistDuongDan(nhanhieu.getDuongdan())){
                model.addAttribute("error", "Đường dẫn đã tồn tại");
            }else{
                model.addAttribute("success", "Cập nhập nhãn hiệu thành công");
                nhanHieuService.update(nhanhieu);
            }
        }
        return "admin/nhanhieu/edit";
    }
}
