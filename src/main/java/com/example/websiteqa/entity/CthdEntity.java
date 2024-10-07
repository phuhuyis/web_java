package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cthd")
@Data
public class CthdEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "soluong")
    private Integer soluong;
    @ManyToOne(optional = false)
    @JoinColumn(name="hoadon")
    private HoadonEntity hoadonEntity;
    @ManyToOne(optional = false)
    @JoinColumn(name="sanpham")
    private SanphamEntity sanphamEntity;
}
