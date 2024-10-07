package com.example.websiteqa.service;

import com.example.websiteqa.model.Giohang;

import java.util.List;

public interface GioHangService {
    List<Giohang> listByKhachHang(int khachhang);
    void add(Giohang giohang);
    void update(Giohang giohang);
    void delete(int id);
    Giohang get(int id);
}
