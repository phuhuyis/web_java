package com.example.websiteqa.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Hoadon {
    private int id;
    private Date ngaydat;
    private Integer trangthai;
    private Integer khachhang;
}
