package edu.mum.finalexam.wallymarty.service.impl;

import edu.mum.finalexam.wallymarty.model.Customer;
import edu.mum.finalexam.wallymarty.repository.ICustomerRepository;
import edu.mum.finalexam.wallymarty.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService implements ICustomerService {

        private ICustomerRepository customerRepository;



    @Autowired
    public CustomerService (ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll(Sort.by("customerNumber"));
    }

    @Override
    public Customer save(Customer Customer) {
        return customerRepository.save(Customer);
    }


//    @Override
//    public customer findById(Long customerId) {
//        return customerRepository.findById(customerId).orElse(null);
//    }
}
