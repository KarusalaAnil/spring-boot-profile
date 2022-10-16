package com.springbootprofile.controller;

import com.springbootprofile.dto.CustomerDto;
import com.springbootprofile.entity.Customer;
import com.springbootprofile.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public List<Customer> saveCustomers(@RequestBody List<Customer> customers){
        return service.saveAllCustomer(customers);
    }

    @GetMapping
    public List<CustomerDto> getCustomers(){
        return service.getCustomers();
    }

}
