package com.example.websiteqa.repository;

import com.example.websiteqa.entity.LienheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LienheRepository extends JpaRepository<LienheEntity, Integer> {
}
