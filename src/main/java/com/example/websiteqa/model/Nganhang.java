package com.example.websiteqa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Data
public class Nganhang {
    private int id;
    private String nganhang;
    @NotBlank(message = "Hãy nhập số tài khoản")
    private String stk;
    @NotBlank(message = "Hãy nhập tên tài khoản")
    private String ten;
    @NotBlank(message = "Hãy nhập nội dung chuyển khoản")
    private String noidungchuyenkhoan;
    private String username;
}
