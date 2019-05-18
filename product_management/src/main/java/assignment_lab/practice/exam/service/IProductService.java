package assignment_lab.practice.exam.service;

import assignment_lab.practice.exam.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product save(Product product);
    Product findById(Long pid);

}
