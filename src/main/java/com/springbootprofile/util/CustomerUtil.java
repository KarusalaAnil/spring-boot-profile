package com.springbootprofile.util;

import com.springbootprofile.dto.CustomerDto;
import com.springbootprofile.entity.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerUtil {

    public static CustomerDto convertEntityToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobile(customer.getMobile());
        customerDto.setDob(getDateFormat(customer.getDob()));
        return customerDto;

    }

    public static String getDateFormat(Date date) {
        return  new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
