package com.example.websiteqa.service;

import com.example.websiteqa.model.Slide;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SlideService {
    List<Slide> list();
    void add(Slide slide);
    boolean checkFile(MultipartFile file);
    String saveFile(MultipartFile file);
    void update(Slide slide);
    void delete(int id);
    Slide get(int id);
    int getViTri();
}
