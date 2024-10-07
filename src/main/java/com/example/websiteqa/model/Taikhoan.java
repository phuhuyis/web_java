package com.example.websiteqa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Taikhoan {
    @NotBlank(message = "Hãy nhập tài khoản")
    private String username;
    @NotBlank(message = "Hãy nhập mật khẩu")
    private String password;
    private Integer quyen;
}
