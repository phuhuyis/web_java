package com.example.websiteqa.api;

import com.example.websiteqa.model.Slide;
import com.example.websiteqa.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin/slide")
public class SlideApi {
    @Autowired
    private SlideService slideService;

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Slide> delete(@PathVariable(name = "id") int id){
        Slide slide = slideService.get(id);
        if(slide == null)
            return ResponseEntity.badRequest().build();
        slideService.delete(id);
        return ResponseEntity.ok(slide);
    }
}
