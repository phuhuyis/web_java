package com.example.websiteqa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Lienhe {
    private int id;
    @NotBlank(message = "Hãy nhập tiêu đề")
    private String tieude;
    @NotBlank(message = "Hãy nhập nội dung")
    private String noidung;
    private Integer trangthai;
    private Integer khachhang;
}
