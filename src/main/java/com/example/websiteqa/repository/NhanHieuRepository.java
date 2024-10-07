package com.example.websiteqa.repository;

import com.example.websiteqa.entity.NhanhieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanHieuRepository extends JpaRepository<NhanhieuEntity, Integer> {
    NhanhieuEntity findNhanhieuEntityById(Integer id);
    NhanhieuEntity findNhanhieuEntityByDuongdan(String duongDan);
}
