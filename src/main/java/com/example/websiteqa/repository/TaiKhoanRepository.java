package com.example.websiteqa.repository;

import com.example.websiteqa.entity.TaikhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaikhoanEntity, String> {
    TaikhoanEntity findTaikhoanEntityByUsername(String username);
    TaikhoanEntity findTaikhoanEntityByUsernameAndPassword(String username, String password);
}
