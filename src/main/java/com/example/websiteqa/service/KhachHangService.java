package com.example.websiteqa.service;

import com.example.websiteqa.model.Khachhang;

import java.util.List;

public interface KhachHangService {
    List<Khachhang> list();
    void add(Khachhang khachhang);
    void update(Khachhang khachhang);
    void delete(int id);
    Khachhang get(int id);
    Khachhang getByUsername(String username);
    void updateAccount(Khachhang khachhang);
}
