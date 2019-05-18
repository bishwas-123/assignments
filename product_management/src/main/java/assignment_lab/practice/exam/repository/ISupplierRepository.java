package assignment_lab.practice.exam.repository;

import assignment_lab.practice.exam.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("supplierRepository")
public interface ISupplierRepository extends JpaRepository<Supplier,Long> {
}
