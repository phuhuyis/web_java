package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "taikhoan")
@Data
public class TaikhoanEntity {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "quyen")
    private Integer quyen;
    @OneToOne(mappedBy = "taikhoanEntity")
    private KhachhangEntity khachhangEntity;
    @OneToOne(mappedBy = "taikhoanEntity")
    private NganhangEntity nganhangEntity;
    @OneToMany(mappedBy = "taikhoanEntity")
    private List<SlideEntity> slides;
}
