package com.example.websiteqa.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hoadon")
@Data
public class HoadonEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "ngaydat")
    private Date ngaydat;
    @Column(name = "trangthai")
    private Integer trangthai;
    @OneToMany(mappedBy = "hoadonEntity", cascade = CascadeType.ALL)
    private List<CthdEntity> cthds;
    @ManyToOne(optional = false)
    @JoinColumn(name = "khachhang", referencedColumnName = "id")
    private KhachhangEntity khachhangEntity;
}
