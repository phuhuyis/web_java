package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.KhachhangEntity;
import com.example.websiteqa.entity.TaikhoanEntity;
import com.example.websiteqa.model.Khachhang;
import com.example.websiteqa.repository.KhachHangRepository;
import com.example.websiteqa.repository.TaiKhoanRepository;
import com.example.websiteqa.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<Khachhang> list() {
        List<KhachhangEntity> entities = khachHangRepository.findAll();
        List<Khachhang> models = new ArrayList<>();
        for(KhachhangEntity item : entities){
            Khachhang khachhang = new Khachhang();
            khachhang.setDiachi(item.getDiachi());
            khachhang.setHovaten(item.getHovaten());
            khachhang.setId(item.getId());
            khachhang.setSdt(item.getSdt());
            khachhang.setUsername(item.getTaikhoanEntity().getUsername());
            models.add(khachhang);
        }
        return models;
    }

    @Override
    public void add(Khachhang khachhang) {
        TaikhoanEntity taikhoanEntity = new TaikhoanEntity();
        taikhoanEntity.setUsername(khachhang.getUsername());
        taikhoanEntity.setPassword(khachhang.getPassword());
        taikhoanEntity.setQuyen(0);
        taikhoanEntity = taiKhoanRepository.save(taikhoanEntity);
        KhachhangEntity khachhangEntity = new KhachhangEntity();
        khachhangEntity.setDiachi(khachhang.getDiachi());
        khachhangEntity.setHovaten(khachhang.getHovaten());
        khachhangEntity.setSdt(khachhang.getSdt());
        khachhangEntity.setTaikhoanEntity(taikhoanEntity);
        khachHangRepository.save(khachhangEntity);
    }

    @Override
    public void update(Khachhang khachhang) {
        KhachhangEntity khachhangEntity = khachHangRepository.findOne(khachhang.getId());
        khachhangEntity.setDiachi(khachhang.getDiachi());
        khachhangEntity.setHovaten(khachhang.getHovaten());
        khachhangEntity.setSdt(khachhang.getSdt());
        khachHangRepository.save(khachhangEntity);
    }

    @Override
    public void delete(int id) {
        String username = get(id).getUsername();
        khachHangRepository.delete(id);
        //taiKhoanRepository.delete(username);
    }

    @Override
    public Khachhang get(int id) {
        KhachhangEntity khachhangEntity = khachHangRepository.findOne(id);
        if(khachhangEntity == null)
            return null;
        Khachhang khachhang = new Khachhang();
        khachhang.setDiachi(khachhangEntity.getDiachi());
        khachhang.setHovaten(khachhangEntity.getHovaten());
        khachhang.setId(khachhangEntity.getId());
        khachhang.setSdt(khachhangEntity.getSdt());
        khachhang.setUsername(khachhangEntity.getTaikhoanEntity().getUsername());
        return khachhang;
    }

    @Override
    public Khachhang getByUsername(String username) {
        KhachhangEntity khachhangEntity = khachHangRepository.findKhachhangEntityByTaikhoanEntity(taiKhoanRepository.findTaikhoanEntityByUsername(username));
        if(khachhangEntity == null)
            return null;
        Khachhang khachhang = new Khachhang();
        khachhang.setDiachi(khachhangEntity.getDiachi());
        khachhang.setHovaten(khachhangEntity.getHovaten());
        khachhang.setId(khachhangEntity.getId());
        khachhang.setSdt(khachhangEntity.getSdt());
        khachhang.setUsername(khachhangEntity.getTaikhoanEntity().getUsername());
        return khachhang;
    }

    @Override
    public void updateAccount(Khachhang khachhang) {
        KhachhangEntity khachhangEntity = khachHangRepository.findKhachhangEntityByTaikhoanEntity(taiKhoanRepository.findOne(khachhang.getUsername()));
        khachhangEntity.setDiachi(khachhang.getDiachi());
        khachhangEntity.setHovaten(khachhang.getHovaten());
        khachhangEntity.setSdt(khachhang.getSdt());
        khachHangRepository.save(khachhangEntity);
        TaikhoanEntity taikhoanEntity = taiKhoanRepository.findOne(khachhang.getUsername());
        taikhoanEntity.setPassword(khachhang.getPassword());
        taiKhoanRepository.save(taikhoanEntity);
    }
}
