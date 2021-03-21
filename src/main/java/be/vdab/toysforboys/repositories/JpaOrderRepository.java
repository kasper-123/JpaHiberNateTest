package be.vdab.toysforboys.repositories;


import be.vdab.toysforboys.domain.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
class JpaOrderRepository implements OrdersRepository {
    private final EntityManager manager;

    JpaOrderRepository(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public List<Orders> findUnshippedOrCalledOrders() {
        return manager.createNamedQuery("Orders.findAllNotShippedCancelled",Orders.class).getResultList();

    }
    @Override
    public Optional<Orders> findById(long id){
        return Optional.ofNullable(manager.find(Orders.class,id));
    }}