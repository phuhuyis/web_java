package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.KhachhangEntity;
import com.example.websiteqa.entity.LienheEntity;
import com.example.websiteqa.model.Khachhang;
import com.example.websiteqa.model.Lienhe;
import com.example.websiteqa.repository.KhachHangRepository;
import com.example.websiteqa.repository.LienheRepository;
import com.example.websiteqa.service.LienHeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LienHeServiceImpl implements LienHeService {
    @Autowired
    private LienheRepository lienheRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<Lienhe> list() {
        List<LienheEntity> entities = lienheRepository.findAll();
        List<Lienhe> models = new ArrayList<>();
        for(LienheEntity item : entities){
            Lienhe lienhe = new Lienhe();
            lienhe.setId(item.getId());
            lienhe.setKhachhang(item.getKhachhangEntity().getId());
            lienhe.setNoidung(item.getNoidung());
            lienhe.setTieude(item.getTieude());
            lienhe.setTrangthai(item.getTrangthai());
            models.add(lienhe);
        }
        return models;
    }

    @Override
    public void add(Lienhe lienhe) {
        LienheEntity lienheEntity = new LienheEntity();
        lienheEntity.setNoidung(lienhe.getNoidung());
        lienheEntity.setTieude(lienhe.getTieude());
        lienheEntity.setTrangthai(lienhe.getTrangthai());
        lienheEntity.setKhachhangEntity(khachHangRepository.findOne(lienhe.getKhachhang()));
        lienheRepository.save(lienheEntity);
    }

    @Override
    public void update(Lienhe lienhe) {
        LienheEntity lienheEntity = new LienheEntity();
        lienheEntity.setNoidung(lienhe.getNoidung());
        lienheEntity.setTieude(lienhe.getTieude());
        lienheEntity.setTrangthai(lienhe.getTrangthai());
        lienheEntity.setKhachhangEntity(khachHangRepository.findOne(lienhe.getKhachhang()));
        lienheEntity.setId(lienhe.getId());
        lienheRepository.save(lienheEntity);
    }

    @Override
    public void delete(int id) {
        lienheRepository.delete(id);
    }

    @Override
    public Lienhe get(int id) {
        LienheEntity lienheEntity = lienheRepository.findOne(id);
        if(lienheEntity == null)
            return null;
        Lienhe lienhe = new Lienhe();
        lienhe.setId(lienheEntity.getId());
        lienhe.setKhachhang(lienheEntity.getKhachhangEntity().getId());
        lienhe.setNoidung(lienheEntity.getNoidung());
        lienhe.setTieude(lienheEntity.getTieude());
        lienhe.setTrangthai(lienheEntity.getTrangthai());
        return lienhe;
    }
}
