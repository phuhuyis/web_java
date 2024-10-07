package com.example.websiteqa.controller.client;

import com.example.websiteqa.model.Lienhe;
import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.service.LienHeService;
import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.NhanHieuService;
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

@Controller(value = "lienheClientController")
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private LienHeService lienHeService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private NhanHieuService nhanHieuService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping({""})
    public String index(@ModelAttribute(name = "contact") Lienhe contact, HttpServletRequest request, Model model){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return "redirect:/login";
        model.addAttribute("title", "Liên hệ");
        model.addAttribute("active", "contact");
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        return "client/contact";
    }

    @PostMapping({""})
    public String index(Model model, @Validated @ModelAttribute(name = "contact") Lienhe contact, BindingResult bindingResult, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return "redirect:/login";
        model.addAttribute("title", "Liên hệ");
        model.addAttribute("active", "contact");
        model.addAttribute("nhanhieus", nhanHieuService.list());
        model.addAttribute("categories", loaiSanPhamService.list());
        if(!bindingResult.hasErrors()){
            contact.setTrangthai(0);
            contact.setKhachhang(khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId());
            lienHeService.add(contact);
            model.addAttribute("success", "Form đã được gửi đi thành công");
        }
        return "client/contact";
    }
}
