package be.vdab.toysforboys.domain;

import be.vdab.toysforboys.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerTest {
    LocalDate date;
    Country land;
    Customer klant;
    Orders order;
    @BeforeEach
    void beforeEach() {
        date = LocalDate.now();
        land = new Country("dcfv");
        klant = new Customer("no", ";opjk", "djh", "vdfb", "by", land, 0);
        order = new Orders(date, date, date, "fvghj", klant, Status.DISPUTED,0);
    }

    @Test
    void toonOrders(){
        System.out.println(klant.getNaam());
        // klant.addOrder(order);

        System.out.println(klant.getOrders());
        System.out.println("TEST" + order.toString());
    }
}