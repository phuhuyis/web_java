package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.TaikhoanEntity;
import com.example.websiteqa.repository.TaiKhoanRepository;
import com.example.websiteqa.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public boolean isExistUsername(String username) {
        return taiKhoanRepository.findTaikhoanEntityByUsername(username) != null;
    }

    @Override
    public boolean login(String taikhoan, String matkhau, int quyen) {
        TaikhoanEntity taiKhoanEntity = taiKhoanRepository.findTaikhoanEntityByUsernameAndPassword(taikhoan, matkhau);
        if(taiKhoanEntity == null)
            return false;
        return taiKhoanEntity.getQuyen() == quyen;
    }
}
