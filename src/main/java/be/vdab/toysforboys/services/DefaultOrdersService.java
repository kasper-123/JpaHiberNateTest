package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Orders;
import be.vdab.toysforboys.exceptions.OrderNietGevondenException;
import be.vdab.toysforboys.repositories.OrdersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
class DefaultOrdersService  implements OrdersService{
    private  final OrdersRepository ordersRepository;

    DefaultOrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Orders> findUnshippedOrders() {
        return ordersRepository.findUnshippedOrCalledOrders();
    }

    @Override
    public Optional<Orders> findById(long id) {
        return ordersRepository.findById(id) ;
    }

    @Override
    @Transactional(readOnly = false)
    public void setStatusShipped(long id) {
        ordersRepository.findById(id).orElseThrow(OrderNietGevondenException::new).setStatusShipped();
    }

    @Override
    @Transactional(readOnly = false)
    public void setShippeddate(long id) {
        ordersRepository.findById(id).orElseThrow(OrderNietGevondenException::new).setShippeddate();

    }
}