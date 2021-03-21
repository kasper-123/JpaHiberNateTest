package be.vdab.toysforboys.services;

import be.vdab.toysforboys.Status;
import be.vdab.toysforboys.domain.Country;
import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.domain.Orders;
import be.vdab.toysforboys.exceptions.OrderNietGevondenException;
import be.vdab.toysforboys.repositories.OrdersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultOrderServiceTest {
    private DefaultOrdersService service;

    @Mock
    private OrdersRepository repository;
    private Orders orders;
    private Customer customer1;
    private Country country1;
    @BeforeEach
    void beforeEach(){
        service=new DefaultOrdersService(repository);
        country1= new Country("test");
        customer1=new Customer("customer1","test","","","",country1,1);
        orders= new Orders(LocalDate.now(),LocalDate.now(),null,"",customer1, Status.PROCESSING,1);
    }


    @Test
    void setShippedDate(){
        when(repository.findById(orders.getId())).thenReturn(Optional.of(orders));
        service.setShippeddate(orders.getId());

        System.out.println(orders.getShippeddate());

        assertThat(orders.getShippeddate()).isEqualTo(LocalDate.now());
        verify(repository).findById(orders.getId());
    }

    @Test
    void setShippedonbestaandeid(){
        assertThatExceptionOfType(OrderNietGevondenException.class).isThrownBy(()->service.setStatusShipped(-1));
        verify(repository).findById(-1);
    }
    @Test
    void setStatusonbestaandeid(){
        assertThatExceptionOfType(OrderNietGevondenException.class).isThrownBy(()->service.setShippeddate(-1));
        verify(repository).findById(-1);
    }
    @Test
    void setStatusshipped() {
        when(repository.findById(orders.getId())).thenReturn(Optional.of(orders));
        service.setStatusShipped(orders.getId());
        assertThat(orders.getStatus()).isEqualTo(Status.SHIPPED);
    }

}