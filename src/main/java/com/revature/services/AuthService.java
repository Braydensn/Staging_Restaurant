package com.revature.services;

import com.revature.exceptions.ExistingEmailException;
import com.revature.exceptions.InvalidLoginException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repositories.CustomerRepository;
import com.revature.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AuthService {

    private CustomerRepository userRepo;
    private EmployeeRepository employeeRepo;

    @Autowired
    public AuthService(CustomerRepository userRepo, EmployeeRepository employeeRepo){
        this.userRepo = userRepo;
        this.employeeRepo = employeeRepo;
    }

    public Customer customerLogin(String email, String password) throws InvalidLoginException {
        Optional<Customer> customer = userRepo.findByEmail(email);
        if(customer.isPresent()){
            if(customer.get().getPassword().equals(password)){
                return customer.get();
            }
            else{
                throw new InvalidLoginException("Password is not correct");
            }
        }
        else{
            throw new InvalidLoginException("No account with that email found");
        }
    }

    public Customer customerRegister(Customer customer) throws ExistingEmailException {
        if(userRepo.findById(customer.getId()).isEmpty()){
            throw new ExistingEmailException("An account with that email already exists");
        }else {
            return userRepo.save(customer);
        }
    }

    public Employee employeeLogin(Integer employeeId, String password) throws InvalidLoginException {
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        if(employee.isPresent()){
            if(employee.get().getPassword().equals(password)){
                return employee.get();
            }else{
                throw new InvalidLoginException("Password is not correct");
            }
        }else{
            throw new InvalidLoginException("No employee with that ID number found");
        }
    }
}
