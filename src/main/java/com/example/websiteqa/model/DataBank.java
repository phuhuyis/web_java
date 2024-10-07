package com.example.websiteqa.model;

import lombok.Data;

import java.util.List;

@Data
public class DataBank {
    public String code;
    public String desc;
    public List<Datum> data;
}
