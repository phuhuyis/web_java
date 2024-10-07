package com.example.websiteqa.repository;

import com.example.websiteqa.entity.GiohangEntity;
import com.example.websiteqa.entity.KhachhangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepository extends JpaRepository<GiohangEntity, Integer> {
    List<GiohangEntity> findAllByKhachhangEntity(KhachhangEntity khachhangEntity);
}
