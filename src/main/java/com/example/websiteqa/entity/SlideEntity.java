package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "slide")
@Data
public class SlideEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "duongdan")
    private String duongdan;
    @Column(name = "vitri")
    private Integer vitri;
    @ManyToOne(optional = false)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private TaikhoanEntity taikhoanEntity;
}
