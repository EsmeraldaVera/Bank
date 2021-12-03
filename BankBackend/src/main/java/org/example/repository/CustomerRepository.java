package org.example.repository;

import org.example.entity.Customer;


import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    List<Customer> findAll(String filter);
    Customer findById(int customerId);

}
