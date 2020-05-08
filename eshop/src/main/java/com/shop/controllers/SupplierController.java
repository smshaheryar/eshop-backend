package com.shop.controllers;

import com.shop.exception.ResourceNotFoundException;
import com.shop.model.Supplier;
import com.shop.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/supplier")
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long supplierId)
            throws ResourceNotFoundException {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(()-> new ResourceNotFoundException("there is no  item with this id="+supplierId));
        return ResponseEntity.ok().body(supplier);
    }

    @PostMapping("/supplier")
    public Supplier saveSupplier(@Valid @RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }


    @PutMapping("/supplier/{id}")
    public ResponseEntity<Supplier> updateSupplierById(@PathVariable(value = "id") Long supplierId,
                                                @Valid @RequestBody Supplier supplierDetails)
            throws ResourceNotFoundException{
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(()-> new ResourceNotFoundException("there is no  item with this id="+supplierId));
        supplier.setTotalBalance(supplierDetails.getTotalBalance());
        supplier.setLastPayment(supplierDetails.getLastPayment());
        supplier.setLastPaymentDate(supplierDetails.getLastPaymentDate());
        supplier.setRemainingBalance(supplierDetails.getRemainingBalance());

        final Supplier updatedSupplier=supplierRepository.save(supplier);
        return ResponseEntity.ok(updatedSupplier);
    }


    @DeleteMapping("/supplier/{id}")
    public Map<String,Boolean> deleteSupplier(@PathVariable(value = "id") Long supplierId)
            throws ResourceNotFoundException{
        Supplier supplier=supplierRepository.findById(supplierId)
                .orElseThrow(()-> new ResourceNotFoundException("this item is not found with this this id="+supplierId));
        supplierRepository.delete(supplier);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return  response;
    }




}
