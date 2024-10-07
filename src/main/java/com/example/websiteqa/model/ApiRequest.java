package com.example.websiteqa.model;

import lombok.Data;

@Data
public class ApiRequest {
    private String accountNo;
    private String accountName;
    private int acqId;
    private int amount;
    private String addInfo;
    private String format;
    private String template;
}
