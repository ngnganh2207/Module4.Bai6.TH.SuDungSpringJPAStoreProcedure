package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
    List<Customer> findAll();
}
