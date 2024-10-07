package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sanpham")
@Data
public class SanphamEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gia")
    private Integer gia;
    @Column(name = "hinhanh")
    private String hinhanh;
    @OneToMany(mappedBy = "sanphamEntity", cascade = CascadeType.ALL)
    private List<CthdEntity> cthds;
    @OneToMany(mappedBy = "sanphamEntity", cascade = CascadeType.ALL)
    private List<GiohangEntity> giohangs;
    @ManyToOne(optional = false)
    @JoinColumn(name = "danhmuc", referencedColumnName = "id")
    private LoaisanphamEntity loaisanphamEntity;
    @ManyToOne(optional = false)
    @JoinColumn(name = "nhanhieu", referencedColumnName = "id")
    private NhanhieuEntity nhanhieuEntity;
}
