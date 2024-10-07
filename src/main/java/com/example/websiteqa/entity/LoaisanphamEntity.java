package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaisanpham")
@Data
public class LoaisanphamEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "duongdan")
    private String duongdan;
    @OneToMany(mappedBy = "loaisanphamEntity")
    private List<SanphamEntity> sanphams;
}
