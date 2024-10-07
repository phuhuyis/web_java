package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "nganhang")
@Data
public class NganhangEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "nganhang")
    private String nganhang;
    @Column(name = "stk")
    private String stk;
    @Column(name = "ten")
    private String ten;
    @Column(name = "noidungchuyenkhoan")
    private String noidungchuyenkhoan;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private TaikhoanEntity taikhoanEntity;
}
