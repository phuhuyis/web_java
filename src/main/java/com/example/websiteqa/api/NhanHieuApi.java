package com.example.websiteqa.api;

import com.example.websiteqa.model.Nhanhieu;
import com.example.websiteqa.service.NhanHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/nhanhieu")
public class NhanHieuApi {
    @Autowired
    private NhanHieuService nhanHieuService;

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Nhanhieu> delete(@PathVariable(name = "id") int id){
        Nhanhieu nhanhieu = nhanHieuService.get(id);
        if(nhanhieu == null)
            return ResponseEntity.badRequest().build();
        nhanHieuService.delete(id);
        return ResponseEntity.ok(nhanhieu);
    }
}
