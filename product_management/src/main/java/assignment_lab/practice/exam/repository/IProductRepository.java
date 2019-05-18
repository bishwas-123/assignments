package assignment_lab.practice.exam.repository;

import assignment_lab.practice.exam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product, Long> {
    // Relies on the default public abstract methods defined in the super interface, JpaRepository<T, ID>
    // We may override or add more methods here, if needed
}
