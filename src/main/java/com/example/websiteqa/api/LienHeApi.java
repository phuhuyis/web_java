package com.example.websiteqa.api;

import com.example.websiteqa.model.Lienhe;
import com.example.websiteqa.service.LienHeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/lienhe")
public class LienHeApi {
    @Autowired
    private LienHeService lienHeService;

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Lienhe> delete(@PathVariable(name = "id") int id){
        Lienhe lienhe = lienHeService.get(id);
        if(lienhe == null)
            return ResponseEntity.badRequest().build();
        lienHeService.delete(id);
        return ResponseEntity.ok(lienhe);
    }

    @PutMapping({"/success/{id}"})
    public ResponseEntity<Lienhe> success(@PathVariable(name = "id") int id){
        Lienhe lienhe = lienHeService.get(id);
        if(lienhe == null)
            return ResponseEntity.badRequest().build();
        lienhe.setTrangthai(1);
        lienHeService.update(lienhe);
        return ResponseEntity.ok(lienhe);
    }

    @PutMapping({"/progress/{id}"})
    public ResponseEntity<Lienhe> progress(@PathVariable(name = "id") int id){
        Lienhe lienhe = lienHeService.get(id);
        if(lienhe == null)
            return ResponseEntity.badRequest().build();
        lienhe.setTrangthai(0);
        lienHeService.update(lienhe);
        return ResponseEntity.ok(lienhe);
    }
}
