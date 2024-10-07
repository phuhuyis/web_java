package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.LoaisanphamEntity;
import com.example.websiteqa.model.Loaisanpham;
import com.example.websiteqa.repository.LoaiSanPhamRepository;
import com.example.websiteqa.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Override
    public List<Loaisanpham> list() {
        List<LoaisanphamEntity> entities = loaiSanPhamRepository.findAll();
        List<Loaisanpham> models = new ArrayList<>();
        for(LoaisanphamEntity item : entities){
            Loaisanpham loaisanpham = new Loaisanpham();
            loaisanpham.setId(item.getId());
            loaisanpham.setDuongdan(item.getDuongdan());
            loaisanpham.setTen(item.getTen());
            models.add(loaisanpham);
        }
        return models;
    }

    @Override
    public void add(Loaisanpham loaisanpham) {
        LoaisanphamEntity entity = new LoaisanphamEntity();
        entity.setDuongdan(loaisanpham.getDuongdan());
        entity.setTen(loaisanpham.getTen());
        loaiSanPhamRepository.save(entity);
    }

    @Override
    public void update(Loaisanpham loaisanpham) {
        LoaisanphamEntity entity = new LoaisanphamEntity();
        entity.setId(loaisanpham.getId());
        entity.setDuongdan(loaisanpham.getDuongdan());
        entity.setTen(loaisanpham.getTen());
        loaiSanPhamRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        loaiSanPhamRepository.delete(id);
    }

    @Override
    public boolean isExistDuongDan(String duongDan) {
        return loaiSanPhamRepository.findLoaisanphamEntityByDuongdan(duongDan) != null;
    }

    @Override
    public Loaisanpham get(int id) {
        LoaisanphamEntity entity = loaiSanPhamRepository.findOne(id);
        if(entity == null)
            return null;
        Loaisanpham model = new Loaisanpham();
        model.setId(entity.getId());
        model.setDuongdan(entity.getDuongdan());
        model.setTen(entity.getTen());
        return model;
    }

    @Override
    public Loaisanpham getByMetatitle(String metatitle) {
        LoaisanphamEntity entity = loaiSanPhamRepository.findLoaisanphamEntityByDuongdan(metatitle);
        if(entity == null)
            return null;
        Loaisanpham model = new Loaisanpham();
        model.setId(entity.getId());
        model.setDuongdan(entity.getDuongdan());
        model.setTen(entity.getTen());
        return model;
    }
}
