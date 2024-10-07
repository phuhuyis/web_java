package com.example.websiteqa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class Sanpham {
    private int id;
    @NotBlank(message = "Hãy nhập tên sản phẩm")
    private String ten;
    @NotNull(message = "Hãy nhập giá")
    private Integer gia;
    private String hinhanh;
    private Integer danhmuc;
    private Integer nhanhieu;
    private MultipartFile file;
}
