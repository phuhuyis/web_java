package com.example.websiteqa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Loaisanpham {
    private int id;
    @NotBlank(message = "Hãy nhập tên loại sản phẩm")
    private String ten;
    @NotBlank(message = "Hãy nhập đường dẫn")
    private String duongdan;
}
