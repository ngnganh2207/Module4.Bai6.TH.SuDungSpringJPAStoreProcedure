package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
    List<Customer> findAll();
}
