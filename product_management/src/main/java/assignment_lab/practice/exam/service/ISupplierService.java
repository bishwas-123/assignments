package assignment_lab.practice.exam.service;

import assignment_lab.practice.exam.model.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> findAll();
    Supplier save(Supplier product);
    Supplier findById(Long pid);
}
