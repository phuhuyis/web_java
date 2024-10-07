package com.example.websiteqa.service;

public interface TaiKhoanService {
    boolean isExistUsername(String username);
    boolean login(String taikhoan, String matkhau, int quyen);
}
