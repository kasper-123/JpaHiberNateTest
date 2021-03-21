package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.Status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaOrderRepository.class)
class JpaOrdersRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JpaOrderRepository repository;
    private final String ORDERS="Orders";

    public JpaOrdersRepositoryTest(JpaOrderRepository repository) {
        this.repository = repository;
    }


    @Test
    void Status(){
        assertThat(repository.findById(1).get().getStatus()).isEqualTo(Status.SHIPPED);
    }

    @Test
    void findAllNotShippedOrCancelled(){
        System.out.println(repository.findUnshippedOrCalledOrders());

        assertThat(repository.findUnshippedOrCalledOrders()).hasSize(countRowsInTableWhere(ORDERS,"not status='SHIPPED' and not status='CANCELLED'"));
    }

    @Test
    void findById(){
        assertThat(repository.findById(1).get().getCustomer().getId()).isEqualTo(86);

    }
    @Test
    void findByIdOnbestaande(){
        assertThat(repository.findById(-1)).isNotPresent();
assertThat(repository.findById(-1)).isNotPresent();
    }

    @Test
    void findProductsFRomOrderId(){
        System.out.println(repository.findById(1).get().getOrderDetails());
        var setje= (repository.findById(1).get().getOrderDetails());
        System.out.println(      setje.stream().toString()
        );
        assertThat(repository.findById(1).get().getOrderDetails()).hasSize(4);


    }



}