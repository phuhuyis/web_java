package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.GiohangEntity;
import com.example.websiteqa.entity.KhachhangEntity;
import com.example.websiteqa.model.Giohang;
import com.example.websiteqa.model.Khachhang;
import com.example.websiteqa.repository.GioHangRepository;
import com.example.websiteqa.repository.KhachHangRepository;
import com.example.websiteqa.repository.SanPhamRepository;
import com.example.websiteqa.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<Giohang> listByKhachHang(int khachhang) {
        List<GiohangEntity> entities = gioHangRepository.findAllByKhachhangEntity(khachHangRepository.findOne(khachhang));
        List<Giohang> models = new ArrayList<>();
        for(GiohangEntity item : entities){
            Giohang giohang = new Giohang();
            giohang.setId(item.getId());
            giohang.setKhachhang(item.getKhachhangEntity().getId());
            giohang.setSanpham(item.getSanphamEntity().getId());
            giohang.setSoluong(item.getSoluong());
            models.add(giohang);
        }
        return models;
    }

    @Override
    public void add(Giohang giohang) {
        GiohangEntity giohangEntity = new GiohangEntity();
        giohangEntity.setKhachhangEntity(khachHangRepository.findOne(giohang.getKhachhang()));
        giohangEntity.setSoluong(giohang.getSoluong());
        giohangEntity.setSanphamEntity(sanPhamRepository.findOne(giohang.getSanpham()));
        gioHangRepository.save(giohangEntity);
    }

    @Override
    public void update(Giohang giohang) {
        GiohangEntity giohangEntity = new GiohangEntity();
        giohangEntity.setKhachhangEntity(khachHangRepository.findOne(giohang.getKhachhang()));
        giohangEntity.setSoluong(giohang.getSoluong());
        giohangEntity.setSanphamEntity(sanPhamRepository.findOne(giohang.getSanpham()));
        giohangEntity.setId(giohang.getId());
        gioHangRepository.save(giohangEntity);
    }

    @Override
    public void delete(int id) {
        gioHangRepository.delete(id);
    }

    @Override
    public Giohang get(int id) {
        GiohangEntity giohangEntity = gioHangRepository.findOne(id);
        if(giohangEntity == null)
            return null;
        Giohang giohang = new Giohang();
        giohang.setId(giohangEntity.getId());
        giohang.setKhachhang(giohangEntity.getKhachhangEntity().getId());
        giohang.setSanpham(giohangEntity.getSanphamEntity().getId());
        giohang.setSoluong(giohangEntity.getSoluong());
        return giohang;
    }
}
