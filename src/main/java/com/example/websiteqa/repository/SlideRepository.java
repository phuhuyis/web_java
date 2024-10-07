package com.example.websiteqa.repository;

import com.example.websiteqa.entity.SlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideRepository extends JpaRepository<SlideEntity, Integer> {
}
