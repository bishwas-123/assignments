package edu.mum.finalexam.wallymarty.repository;

import edu.mum.finalexam.wallymarty.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface ICustomerRepository extends JpaRepository<Customer,Long> {


}
