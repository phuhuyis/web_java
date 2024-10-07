package com.example.websiteqa.service;

import com.example.websiteqa.model.Loaisanpham;
import com.example.websiteqa.model.Nhanhieu;

import java.util.List;

public interface NhanHieuService {
    List<Nhanhieu> list();
    void add(Nhanhieu nhanhieu);
    void update(Nhanhieu nhanhieu);
    void delete(int id);
    boolean isExistDuongDan(String duongDan);
    Nhanhieu get(int id);
    Nhanhieu getByMetatitle(String metatitle);
}
