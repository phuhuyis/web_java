package com.example.websiteqa.repository;

import com.example.websiteqa.entity.LoaisanphamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaisanphamEntity, Integer> {
    LoaisanphamEntity findLoaisanphamEntityByDuongdan(String duongDan);
}
