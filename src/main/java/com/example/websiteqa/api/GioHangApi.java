package com.example.websiteqa.api;

import com.example.websiteqa.model.Giohang;
import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.GioHangService;
import com.example.websiteqa.service.KhachHangService;
import com.example.websiteqa.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class GioHangApi {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private GioHangService gioHangService;

    @GetMapping("")
    public ResponseEntity<List<Giohang>> list(HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        int khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        List<Giohang> giohangs = gioHangService.listByKhachHang(khachhang);
        return ResponseEntity.ok(giohangs);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Giohang giohang, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        if(giohang.getSoluong() == null || giohang.getSanpham() == null)
            return ResponseEntity.badRequest().build();
        int khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        List<Giohang> giohangs = gioHangService.listByKhachHang(khachhang);
        for(Giohang item : giohangs){
            if(item.getSanpham() == giohang.getSanpham()){
                item.setSoluong(item.getSoluong() + giohang.getSoluong());
                gioHangService.update(item);
                return ResponseEntity.ok("");
            }
        }
        giohang.setKhachhang(khachhang);
        gioHangService.add(giohang);
        return ResponseEntity.ok("");
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Giohang giohang, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        if(giohang.getSoluong() == null || giohang.getSanpham() == null)
            return ResponseEntity.badRequest().build();
        int khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        List<Giohang> giohangs = gioHangService.listByKhachHang(khachhang);
        for(Giohang item : giohangs){
            if(item.getSanpham() == giohang.getSanpham()){
                item.setSoluong(giohang.getSoluong());
                gioHangService.update(item);
                return ResponseEntity.ok("");
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody Giohang giohang, HttpServletRequest request){
        if(SessionUtil.getInstance().getKey(request, "user") == null
                || ((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getQuyen() != 0)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        if(giohang.getSanpham() == null)
            return ResponseEntity.badRequest().build();
        int khachhang = khachHangService.getByUsername(((Taikhoan)SessionUtil.getInstance().getKey(request, "user")).getUsername()).getId();
        List<Giohang> giohangs = gioHangService.listByKhachHang(khachhang);
        for(Giohang item : giohangs){
            if(item.getSanpham() == giohang.getSanpham()){
                gioHangService.delete(item.getId());
                return ResponseEntity.ok("");
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
