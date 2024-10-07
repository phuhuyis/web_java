package com.example.websiteqa.service;

import com.example.websiteqa.model.Loaisanpham;

import java.util.List;

public interface LoaiSanPhamService {
    List<Loaisanpham> list();
    void add(Loaisanpham loaisanpham);
    void update(Loaisanpham loaisanpham);
    void delete(int id);
    boolean isExistDuongDan(String duongDan);
    Loaisanpham get(int id);
    Loaisanpham getByMetatitle(String metatitle);
}
