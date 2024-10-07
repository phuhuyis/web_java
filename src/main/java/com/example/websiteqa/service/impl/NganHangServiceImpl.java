package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.NganhangEntity;
import com.example.websiteqa.model.Nganhang;
import com.example.websiteqa.repository.NganHangRepository;
import com.example.websiteqa.repository.TaiKhoanRepository;
import com.example.websiteqa.service.NganHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NganHangServiceImpl implements NganHangService {
    @Autowired
    private NganHangRepository nganHangRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public void update(Nganhang nganhang) {
        NganhangEntity entity = new NganhangEntity();
        entity.setId(nganhang.getId());
        entity.setNganhang(nganhang.getNganhang());
        entity.setStk(nganhang.getStk());
        entity.setTen(nganhang.getTen());
        entity.setNoidungchuyenkhoan(nganhang.getNoidungchuyenkhoan());
        entity.setTaikhoanEntity(taiKhoanRepository.getOne(nganhang.getUsername()));
        nganHangRepository.save(entity);
    }

    @Override
    public Nganhang get() {
        List<NganhangEntity> entities = nganHangRepository.findAll();
        if(entities.size() == 0 || entities.size() > 1)
            return null;
        Nganhang nganhang = new Nganhang();
        nganhang.setId(entities.get(0).getId());
        nganhang.setNganhang(entities.get(0).getNganhang());
        nganhang.setNoidungchuyenkhoan(entities.get(0).getNoidungchuyenkhoan());
        nganhang.setStk(entities.get(0).getStk());
        nganhang.setUsername(entities.get(0).getTaikhoanEntity().getUsername());
        nganhang.setTen(entities.get(0).getTen());
        return nganhang;
    }
}
