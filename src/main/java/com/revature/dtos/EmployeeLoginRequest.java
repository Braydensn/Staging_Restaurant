package com.revature.dtos;

import lombok.Data;

@Data
public class EmployeeLoginRequest {
    Integer employeeId;
    String password;
}
