package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(Long id);
    Optional<String>findNaamById(Long id);

}
