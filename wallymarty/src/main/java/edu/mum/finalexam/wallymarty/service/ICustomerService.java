package edu.mum.finalexam.wallymarty.service;

import edu.mum.finalexam.wallymarty.model.Customer;

import java.util.List;

public interface ICustomerService {
        List<Customer> findAll();
       // List<Customer>findAll(Fi);
        Customer save(Customer Customer);

}
