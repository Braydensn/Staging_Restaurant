package com.revature.dtos;

import lombok.Data;

@Data
public class CustomerLoginRequest {
    String email;
    String password;
}
