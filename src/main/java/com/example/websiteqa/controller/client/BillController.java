package com.example.websiteqa.controller.client;

import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.HoaDonService;
import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.service.SanPhamService;
import com.example.websiteqa.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping({""})
    public String home(Model model, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return "redirect:/login";
        int khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        model.addAttribute("listBill", hoaDonService.listByKhachHang(khachhang));
        model.addAttribute("title", "Danh sách hóa đơn");
        model.addAttribute("active", "bill");
        return "client/bill/index";
    }

    @GetMapping({"/detail/{id}"})
    public String detail(@PathVariable(name = "id")int id, Model model, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return "redirect:/login";
        model.addAttribute("listDetail", hoaDonService.getDetailById(id));
        model.addAttribute("listProduct", sanPhamService.list());
        model.addAttribute("title", "Chi tiết hóa đơn");
        model.addAttribute("active", "bill");
        return "client/bill/detail";
    }
}
