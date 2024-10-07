package com.example.websiteqa.repository;

import com.example.websiteqa.entity.CthdEntity;
import com.example.websiteqa.entity.HoadonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CthdRepository extends JpaRepository<CthdEntity, Integer> {
    List<CthdEntity> findAllByHoadonEntity(HoadonEntity hoadonEntity);
}
