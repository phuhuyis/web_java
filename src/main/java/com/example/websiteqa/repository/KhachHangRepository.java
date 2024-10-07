package com.example.websiteqa.repository;

import com.example.websiteqa.entity.KhachhangEntity;
import com.example.websiteqa.entity.TaikhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachhangEntity, Integer> {
    KhachhangEntity findKhachhangEntityByTaikhoanEntity(TaikhoanEntity taikhoanEntity);
}
