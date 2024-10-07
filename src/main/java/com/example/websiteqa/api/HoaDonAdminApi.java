package com.example.websiteqa.api;

import com.example.websiteqa.model.Hoadon;
import com.example.websiteqa.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/hoadon")
public class HoaDonAdminApi {
    @Autowired
    private HoaDonService hoaDonService;

    @PutMapping({"/{id}"})
    public ResponseEntity<?> paid(@PathVariable(name = "id") int id){
        Hoadon hoadon = hoaDonService.get(id);
        if(hoadon == null)
            return ResponseEntity.badRequest().build();
        try {
            hoadon.setTrangthai(1);
            hoaDonService.update(hoadon);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ResponseEntity.ok(hoadon);
    }

    @PostMapping({"/{id}"})
    public ResponseEntity<?> unpaid(@PathVariable(name = "id") int id){
        Hoadon hoadon = hoaDonService.get(id);
        if(hoadon == null)
            return ResponseEntity.badRequest().build();
        try {
            hoadon.setTrangthai(0);
            hoaDonService.update(hoadon);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ResponseEntity.ok(hoadon);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        Hoadon hoadon = hoaDonService.get(id);
        if(hoadon == null)
            return ResponseEntity.badRequest().build();
        try {
            hoaDonService.delete(id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ResponseEntity.ok(hoadon);
    }
}
