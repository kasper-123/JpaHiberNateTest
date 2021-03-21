package be.vdab.toysforboys.repositories;


import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);
    Optional<String> findNaamById(Long id);
    List<String> findAllNames();
    List<Orders> findOrders(Long id);

}