package com.example.websiteqa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Data
public class Khachhang {
    private int id;
    @NotBlank(message = "Hãy nhập họ và tên")
    private String hovaten;
    @NotBlank(message = "Hãy nhập địa chỉ")
    private String diachi;
    @NotBlank(message = "Hãy nhập số điện thoại")
    @Pattern(regexp = "()|(\\+84|0)(3[2-9]|5[2689]|7[06-9]|8[1-689]|9\\d)(\\d{7})", message = "Số điện thoại không hợp lệ")
    private String sdt;
    @NotBlank(message = "Hãy nhập tài khoản")
    private String username;
    @NotBlank(message = "Hãy nhập mật khẩu")
    private String password;
}
