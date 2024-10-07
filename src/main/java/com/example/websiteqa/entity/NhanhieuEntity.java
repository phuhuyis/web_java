package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhanhieu")
@Data
public class NhanhieuEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "duongdan")
    private String duongdan;
    @OneToMany(mappedBy = "nhanhieuEntity")
    private List<SanphamEntity> sanphams;
}
