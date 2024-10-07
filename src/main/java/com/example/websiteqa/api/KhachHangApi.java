package com.example.websiteqa.api;

import com.example.websiteqa.model.Khachhang;
import com.example.websiteqa.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/khachhang")
public class KhachHangApi {
    @Autowired
    private KhachHangService khachHangService;

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Khachhang> delete(@PathVariable(name = "id") int id){
        Khachhang khachhang = khachHangService.get(id);
        if(khachhang == null)
            return ResponseEntity.badRequest().build();
        khachHangService.delete(id);
        return ResponseEntity.ok(khachhang);
    }
}
