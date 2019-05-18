package edu.mum.cs.cs425.finalexam.prodmgmt.repository;

import edu.mum.cs.cs425.finalexam.prodmgmt.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface IRepository  extends CrudRepository<Product,Integer> {
}
