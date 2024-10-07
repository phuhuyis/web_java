package com.example.websiteqa.service;

import com.example.websiteqa.model.Cthd;
import com.example.websiteqa.model.Giohang;
import com.example.websiteqa.model.Hoadon;

import java.util.List;

public interface HoaDonService {
    void createBill(List<Giohang> giohangs, Hoadon hoaDon, int khachHang);
    List<Hoadon> listByKhachHang(int khachHang);
    List<Cthd> getDetailById(int id);
    List<Hoadon> list();
    void delete(int id);
    void update(Hoadon hoadon);
    Hoadon get(int id);
    String createQR(int amount);
}
