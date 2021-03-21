package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DefaultCustomerService implements   CustomerService {
    private final CustomerRepository repository;

    public DefaultCustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }



    @Override
    public Optional<String> findNaamById(Long id) {
        return repository.findNaamById(id);
    }
}