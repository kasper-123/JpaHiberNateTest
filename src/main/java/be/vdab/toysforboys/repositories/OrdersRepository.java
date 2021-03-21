package be.vdab.toysforboys.repositories;


import be.vdab.toysforboys.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository {

    List<Orders> findUnshippedOrCalledOrders();
    Optional<Orders> findById(long id);


}