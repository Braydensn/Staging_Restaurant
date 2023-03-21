package com.revature.controllers;

import com.revature.dtos.CustomerLoginRequest;
import com.revature.dtos.EmployeeLoginRequest;
import com.revature.exceptions.ExistingEmailException;
import com.revature.exceptions.InvalidLoginException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true", exposedHeaders = "Authorization")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/customer/login")
    public ResponseEntity<Customer> customerLogin(@RequestBody CustomerLoginRequest login) throws InvalidLoginException {
        return ResponseEntity.ok(authService.customerLogin(login.getEmail(), login.getPassword()));
    }

    @PostMapping("/customer/register")
    public ResponseEntity<Customer> customerRegister(@RequestBody Customer customer) throws ExistingEmailException {
        Customer newCustomer = authService.customerRegister(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @PostMapping("employee/login")
    public ResponseEntity<Employee> employeeLogin(@RequestBody EmployeeLoginRequest login) throws InvalidLoginException {
        return ResponseEntity.ok(authService.employeeLogin(login.getEmployeeId(), login.getPassword()));
    }

}
