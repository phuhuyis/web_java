package com.example.websiteqa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Nhanhieu {
    private int id;
    @NotBlank(message = "Hãy nhập tên nhãn hiệu")
    private String ten;
    @NotBlank(message = "Hãy nhập đường dẫn")
    private String duongdan;
}
