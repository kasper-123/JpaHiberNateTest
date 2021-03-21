package be.vdab.toysforboys.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(JpaCustomerRepository.class)
//@Sql("/insertCustomer.sql")
class JpaCustomerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String CUSTOMERS ="customers";
    private static final String ORDERS = "orders";
    private final JpaCustomerRepository repository;


    JpaCustomerRepositoryTest(JpaCustomerRepository repository) {
        this.repository = repository;
    }
    @Test
    void findbyid(){
        assertThat(repository.findById(1L)
                .get().getNaam()).isEqualTo("Atelier graphique");

    }
    @Test
    void findbyidbestaatniet(){
        assertThat(repository.findById((long) -1)).isNotPresent();
    }
    @Test
    void findByIdNullMislukt(){
        assertThatNullPointerException().isThrownBy(()->repository.findById(null));
    }
    @Test
    void findAllNames(){
        assertThat(repository.findAllNames()).hasSize(countRowsInTable(CUSTOMERS));
    }
    @Test
    void findName(){
        assertThat(repository.findNaamById(1L)).get().isEqualTo("Atelier graphique");
    }

    @Test
    void findNaaamMislukingen() {

        assertThatNullPointerException().isThrownBy(()->repository.findNaamById(null));

    }

    @Test
    void toonorders(){
        //   System.out.println(Arrays.toString(repository.findOrders(1L).stream()));
        System.out.println(" drgtrgreg"+repository.findOrders(1L).stream().toString());
        assertThat(repository.findOrders(1L)).hasSize(countRowsInTableWhere(ORDERS,"id = 1"));

    }
}