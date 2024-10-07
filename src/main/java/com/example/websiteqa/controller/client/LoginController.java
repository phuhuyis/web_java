package com.example.websiteqa.controller.client;

import com.example.websiteqa.model.Taikhoan;
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

@Controller(value = "loginClientController")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping({""})
    public String index(@ModelAttribute(name = "taikhoan") Taikhoan taiKhoan){
        return "client/login";
    }

    @PostMapping({""})
    public String index(Model model, @Validated @ModelAttribute(name = "taikhoan") Taikhoan taiKhoan, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            if(taiKhoanService.login(taiKhoan.getUsername(), taiKhoan.getPassword(), 0)){
                model.addAttribute("success", "Đăng nhập thành công");
                Taikhoan item = new Taikhoan();
                item.setUsername(taiKhoan.getUsername());
                item.setQuyen(0);
                SessionUtil.getInstance().putKey(request, "user", item);
            }else{
                model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
            }
        }
        return "client/login";
    }
}
