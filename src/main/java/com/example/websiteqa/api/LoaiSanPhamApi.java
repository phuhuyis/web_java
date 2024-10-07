package com.example.websiteqa.api;

import com.example.websiteqa.model.Loaisanpham;
import com.example.websiteqa.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/loaisanpham")
public class LoaiSanPhamApi {
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Loaisanpham> delete(@PathVariable(name = "id") int id){
        Loaisanpham loaisanpham = loaiSanPhamService.get(id);
        if(loaisanpham == null)
            return ResponseEntity.badRequest().build();
        loaiSanPhamService.delete(id);
        return ResponseEntity.ok(loaisanpham);
    }
}
