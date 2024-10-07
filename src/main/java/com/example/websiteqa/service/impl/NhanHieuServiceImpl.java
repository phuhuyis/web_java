package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.NhanhieuEntity;
import com.example.websiteqa.model.Nhanhieu;
import com.example.websiteqa.repository.NhanHieuRepository;
import com.example.websiteqa.service.NhanHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanHieuServiceImpl implements NhanHieuService {
    @Autowired
    private NhanHieuRepository nhanHieuRepository;

    @Override
    public List<Nhanhieu> list() {
        List<NhanhieuEntity> entities = nhanHieuRepository.findAll();
        List<Nhanhieu> models = new ArrayList<>();
        for(NhanhieuEntity item : entities){
            Nhanhieu nhanhieu = new Nhanhieu();
            nhanhieu.setId(item.getId());
            nhanhieu.setDuongdan(item.getDuongdan());
            nhanhieu.setTen(item.getTen());
            models.add(nhanhieu);
        }
        return models;
    }

    @Override
    public void add(Nhanhieu nhanhieu) {
        NhanhieuEntity entity = new NhanhieuEntity();
        entity.setDuongdan(nhanhieu.getDuongdan());
        entity.setTen(nhanhieu.getTen());
        nhanHieuRepository.save(entity);
    }

    @Override
    public void update(Nhanhieu nhanhieu) {
        NhanhieuEntity entity = new NhanhieuEntity();
        entity.setId(nhanhieu.getId());
        entity.setDuongdan(nhanhieu.getDuongdan());
        entity.setTen(nhanhieu.getTen());
        nhanHieuRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        nhanHieuRepository.delete(id);
    }

    @Override
    public boolean isExistDuongDan(String duongDan) {
        return nhanHieuRepository.findNhanhieuEntityByDuongdan(duongDan) != null;
    }

    @Override
    public Nhanhieu get(int id) {
        NhanhieuEntity entity = nhanHieuRepository.findOne(id);
        if(entity == null)
            return null;
        Nhanhieu model = new Nhanhieu();
        model.setId(entity.getId());
        model.setDuongdan(entity.getDuongdan());
        model.setTen(entity.getTen());
        return model;
    }

    @Override
    public Nhanhieu getByMetatitle(String metatitle) {
        NhanhieuEntity entity = nhanHieuRepository.findNhanhieuEntityByDuongdan(metatitle);
        if(entity == null)
            return null;
        Nhanhieu model = new Nhanhieu();
        model.setId(entity.getId());
        model.setDuongdan(entity.getDuongdan());
        model.setTen(entity.getTen());
        return model;
    }
}
