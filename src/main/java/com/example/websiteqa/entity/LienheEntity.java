package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lienhe")
@Data
public class LienheEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "tieude")
    private String tieude;
    @Column(name = "noidung")
    private String noidung;
    @Column(name = "trangthai")
    private Integer trangthai;
    @ManyToOne(optional = false)
    @JoinColumn(name = "khachhang", referencedColumnName = "id")
    private KhachhangEntity khachhangEntity;
}
