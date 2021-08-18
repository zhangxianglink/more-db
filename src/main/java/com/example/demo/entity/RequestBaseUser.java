package com.example.demo.entity;

import lombok.Data;

@Data
public class RequestBaseUser {
    private String name;
    private String departmentCode;
    private String workNumber;
    private String managerDeptCode;
}
