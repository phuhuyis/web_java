package com.example.websiteqa.api;

import com.example.websiteqa.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/report")
public class ReportApi {
    @Autowired
    private ReportService reportService;

    @GetMapping({"/getAmount"})
    public ResponseEntity<?> getAmount(){
        List<Integer> results = reportService.getAllPrice();
        return ResponseEntity.ok(results);
    }

    @GetMapping({"/getQuantity"})
    public ResponseEntity<?> getQuantity(){
        List<Integer> results = reportService.getAllQuantity();
        return ResponseEntity.ok(results);
    }
}
