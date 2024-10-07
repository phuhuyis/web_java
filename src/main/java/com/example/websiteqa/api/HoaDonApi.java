package com.example.websiteqa.api;

import com.example.websiteqa.model.Giohang;
import com.example.websiteqa.model.Hoadon;
import com.example.websiteqa.model.Sanpham;
import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.GioHangService;
import com.example.websiteqa.service.HoaDonService;
import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.service.SanPhamService;
import com.example.websiteqa.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDonApi {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private SanPhamService sanPhamService;

    @PostMapping("")
    public ResponseEntity<?> add(HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        int khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        List<Giohang> giohangs = gioHangService.listByKhachHang(khachhang);
        if(giohangs == null || giohangs.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        hoaDonService.createBill(giohangs, new Hoadon(), khachhang);
        for(Giohang giohang : giohangs){
            gioHangService.delete(giohang.getId());
        }
        return ResponseEntity.ok("success");
    }

    @GetMapping("/createQR")
    public ResponseEntity<?> createQR(HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        int khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        List<Giohang> giohangs = gioHangService.listByKhachHang(khachhang);
        if(giohangs == null || giohangs.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        int amount = 0;
        List<Sanpham> sanphams = sanPhamService.list();
        for(Giohang giohang : giohangs){
            for(Sanpham sanpham : sanphams){
                if(sanpham.getId() == giohang.getSanpham()){
                    amount += giohang.getSoluong() * sanpham.getGia();
                }
            }
        }
        return ResponseEntity.ok(hoaDonService.createQR(amount));
    }
}
