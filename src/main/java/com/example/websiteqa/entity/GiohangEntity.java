package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "giohang")
@Data
public class GiohangEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "soluong")
    private Integer soluong;
    @ManyToOne(optional = false)
    @JoinColumn(name="khachhang", referencedColumnName = "id")
    private KhachhangEntity khachhangEntity;
    @ManyToOne(optional = false)
    @JoinColumn(name="sanpham", referencedColumnName = "id")
    private SanphamEntity sanphamEntity;
}
