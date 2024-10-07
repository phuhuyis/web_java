package com.example.websiteqa.controller.admin;

import com.example.websiteqa.model.Slide;
import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.SlideService;
import com.example.websiteqa.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "slideAdmin")
@RequestMapping("/admin/slide")
public class SlideController {
    @Autowired
    private SlideService slideService;

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("listSlide", slideService.list());
        model.addAttribute("title", "Quản lý slide");
        model.addAttribute("active", "slide");
        return "admin/slide/list";
    }

    @GetMapping({"/create"})
    public String create(Model model){
        model.addAttribute("title", "Thêm slide");
        model.addAttribute("active", "slide");
        Slide slide = new Slide();
        slide.setVitri(slideService.getViTri());
        model.addAttribute("slide", slide);
        return "admin/slide/create";
    }

    @PostMapping({"/create"})
    public String create(@Validated @ModelAttribute(name = "slide")Slide slide, BindingResult bindingResult, Model model, HttpServletRequest request){
        model.addAttribute("title", "Thêm slide");
        model.addAttribute("active", "slide");
        if(!bindingResult.hasErrors()){
            if(!slideService.checkFile(slide.getFile())){
                model.addAttribute("error", "Chưa chọn hình ảnh hoặc file hình ảnh không hợp lệ chỉ nhận định dạng jpg, png, jpeg");
            }else{
                slide.setVitri(slideService.getViTri());
                slide.setUsername(((Taikhoan) SessionUtil.getInstance().getKey(request, "user")).getUsername());
                model.addAttribute("success", "Thêm slide thành công");
                slideService.add(slide);
                slide = new Slide();
                slide.setVitri(slideService.getViTri());
                model.addAttribute("slide", slide);
            }
        }
        return "admin/slide/create";
    }

    @GetMapping({"/edit/{id}"})
    public String edit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("title", "Cập nhập slide");
        model.addAttribute("active", "slide");
        model.addAttribute("slide", slideService.get(id));
        return "admin/slide/edit";
    }

    @PostMapping({"/edit/{id}"})
    public String edit(@Validated @ModelAttribute(name = "slide")Slide slide, BindingResult bindingResult, @PathVariable(name = "id") int id, Model model, HttpServletRequest request){
        model.addAttribute("title", "Cập nhập slide");
        model.addAttribute("active", "slide");
        if(!bindingResult.hasErrors()){
            if(!slideService.checkFile(slide.getFile())){
                model.addAttribute("error", "Chưa chọn hình ảnh hoặc file hình ảnh không hợp lệ chỉ nhận định dạng jpg, png, jpeg");
            }else{
                slide.setVitri(slideService.get(id).getVitri());
                slide.setUsername(((Taikhoan) SessionUtil.getInstance().getKey(request, "user")).getUsername());
                model.addAttribute("success", "Cập nhập slide thành công");
                slideService.update(slide);
            }
        }
        return "admin/slide/edit";
    }
}
