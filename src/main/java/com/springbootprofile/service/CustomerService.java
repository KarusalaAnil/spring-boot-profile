package com.springbootprofile.service;

import com.springbootprofile.dto.CustomerDto;
import com.springbootprofile.entity.Customer;
import com.springbootprofile.repository.CustomerRepository;
import com.springbootprofile.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile(value = {"dev","stg","prod"})
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Value("${application.message}")
    private String message;

    @PostConstruct
    public void init() {
        System.out.println("**************** "+message);
    }
    public List<Customer> saveAllCustomer(List<Customer> customers){
        return repository.saveAll(customers);
    }
    public List<CustomerDto> getCustomers(){
//        return repository.findAll();
        List<Customer> customerList =repository.findAll();
        return customerList.stream().map(customer ->
                new CustomerUtil().convertEntityToDto(customer)).collect(Collectors.toList());
    }


}
