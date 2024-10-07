package com.example.websiteqa.controller.client;

import com.example.websiteqa.model.Khachhang;
import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.KhachHangService;
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

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping({""})
    public String index(@ModelAttribute(name = "khachhang") Khachhang khachhang){
        return "client/register";
    }

    @PostMapping({""})
    public String index(Model model, @Validated @ModelAttribute(name = "khachhang") Khachhang khachhang, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            if(taiKhoanService.isExistUsername(khachhang.getUsername())){
                model.addAttribute("error", "Tài khoản đã tồn tại");
            }else{
                model.addAttribute("success", "Đăng ký thành công");
                khachHangService.add(khachhang);
                Taikhoan item = new Taikhoan();
                item.setUsername(khachhang.getUsername());
                item.setQuyen(0);
                SessionUtil.getInstance().putKey(request, "user", item);
            }
        }
        return "client/register";
    }
}
