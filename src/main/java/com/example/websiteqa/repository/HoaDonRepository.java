package com.example.websiteqa.repository;

import com.example.websiteqa.entity.HoadonEntity;
import com.example.websiteqa.entity.KhachhangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoadonEntity, Integer> {
    List<HoadonEntity> findAllByKhachhangEntity(KhachhangEntity khachhangEntity);
}
