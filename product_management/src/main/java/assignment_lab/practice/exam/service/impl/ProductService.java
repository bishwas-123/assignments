package assignment_lab.practice.exam.service.impl;

import assignment_lab.practice.exam.repository.IProductRepository;
import assignment_lab.practice.exam.model.Product;
import assignment_lab.practice.exam.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductService (IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll(Sort.by("productNumber"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
