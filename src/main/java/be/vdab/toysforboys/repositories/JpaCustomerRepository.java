package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.domain.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
class JpaCustomerRepository implements CustomerRepository{
    private final EntityManager manager;

    JpaCustomerRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        if(id ==null){
            throw new NullPointerException();
        }
        return Optional.ofNullable(manager.find(Customer.class,id));
    }

    @Override
    public Optional<String> findNaamById(Long id) {
        if(id ==null){
            throw new NullPointerException();
        }
        return Optional.ofNullable(manager.createNamedQuery("Customer.findName",String.class).setParameter("id",id).getSingleResult());
    }

    @Override
    public List<String> findAllNames() {

        return manager.createNamedQuery("Customer.findAllNames",String.class).getResultList();
    }

    @Override
    public List<Orders> findOrders(Long id) {

        return manager.createNamedQuery("Orders.findOrdersById",Orders.class).setParameter("id",id).getResultList();
    }}
