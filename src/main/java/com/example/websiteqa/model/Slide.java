package com.example.websiteqa.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Slide {
    private int id;
    private String duongdan;
    private Integer vitri;
    private String username;
    private MultipartFile file;
}