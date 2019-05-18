package assignment_lab.practice.exam.service.impl;

import assignment_lab.practice.exam.model.Supplier;
import assignment_lab.practice.exam.repository.ISupplierRepository;
import assignment_lab.practice.exam.service.ISupplierService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supplierService")
public class SupplierService implements ISupplierService {
    private ISupplierRepository supplierRepository;
    public SupplierService(ISupplierRepository supplierRepository){
        this.supplierRepository=supplierRepository;
    }
    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll(Sort.by("supplierName"));
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier findById(Long pid) {
        return supplierRepository.findById(pid).orElse(null);
    }
}
