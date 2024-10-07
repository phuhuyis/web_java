package com.example.websiteqa.controller.admin;

import com.example.websiteqa.service.HoaDonService;
import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "hoaDonAdmin")
@RequestMapping("/admin/hoadon")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping({""})
    public String home(Model model){
        model.addAttribute("listHoaDon", hoaDonService.list());
        model.addAttribute("listKhachHang", khachHangService.list());
        model.addAttribute("title", "Quản lý hóa đơn");
        model.addAttribute("active", "hoadon");
        return "admin/hoadon/list";
    }

    @GetMapping({"/detail/{id}"})
    public String detail(@PathVariable(name = "id")int id, Model model){
        model.addAttribute("listChiTiet", hoaDonService.getDetailById(id));
        model.addAttribute("trangthai", hoaDonService.get(id).getTrangthai());
        model.addAttribute("id", id);
        model.addAttribute("listSanPham", sanPhamService.list());
        model.addAttribute("title", "Chi tiết hóa đơn");
        model.addAttribute("active", "hoadon");
        return "admin/hoadon/detail";
    }
}
