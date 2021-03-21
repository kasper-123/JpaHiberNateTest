package be.vdab.toysforboys.domain;

import be.vdab.toysforboys.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    private Orders order1;
    private Customer customer1;
    private Country country1;

    @BeforeEach
    void beforeEach(){
        country1= new Country("test");
        customer1=new  Customer("customer1","test","","","",country1,1);
        order1= new Orders(LocalDate.now(),LocalDate.now(),null,"",customer1, Status.PROCESSING,1);
    }
    @Test
    void setShippedDate(){
        order1.setShippeddate();
        assertThat(order1.getShippeddate()).isEqualTo(LocalDate.now());
    }
    @Test
    void setcustomer(){
        var customer2=new  Customer("customer2","test","","","",country1,1);

        order1.setCustomer(customer2);
        assertThat(order1.getCustomer().getNaam()).isEqualTo("customer2");
    }
    @Test
    void setStatusShipped(){
        order1.setStatusShipped();
        assertThat(order1.getStatus()).isEqualTo(Status.SHIPPED);
    }
}