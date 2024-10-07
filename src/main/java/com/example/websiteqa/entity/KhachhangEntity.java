package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "khachhang")
@Data
public class KhachhangEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "hovaten")
    private String hovaten;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "sdt")
    private String sdt;
    @OneToMany(mappedBy = "khachhangEntity", cascade = CascadeType.ALL)
    private List<GiohangEntity> giohangs;
    @OneToMany(mappedBy = "khachhangEntity", cascade = CascadeType.ALL)
    private List<HoadonEntity> hoadons;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private TaikhoanEntity taikhoanEntity;
    @OneToMany(mappedBy = "khachhangEntity", cascade = CascadeType.ALL)
    private List<LienheEntity> lienhes;
}
