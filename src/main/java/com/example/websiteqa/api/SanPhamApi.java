package com.example.websiteqa.api;

import com.example.websiteqa.model.Loaisanpham;
import com.example.websiteqa.model.Sanpham;
import com.example.websiteqa.service.LoaiSanPhamService;
import com.example.websiteqa.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin/sanpham")
public class SanPhamApi {
    @Autowired
    private SanPhamService sanPhamService;

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Sanpham> delete(@PathVariable(name = "id") int id){
        Sanpham sanpham = sanPhamService.get(id);
        if(sanpham == null)
            return ResponseEntity.badRequest().build();
        try {
            sanPhamService.delete(id);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return ResponseEntity.ok(sanpham);
    }
}
