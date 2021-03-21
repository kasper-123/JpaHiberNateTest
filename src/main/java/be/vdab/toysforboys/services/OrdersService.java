package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<Orders> findUnshippedOrders();
    Optional<Orders> findById(long id);
    void setStatusShipped(long id);
    void setShippeddate(long id);
}
