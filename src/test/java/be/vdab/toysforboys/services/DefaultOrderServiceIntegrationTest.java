package be.vdab.toysforboys.services;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(DefaultOrdersService.class)
@ComponentScan(value = "be.vdab.toysforboys.repositories",resourcePattern = "JpaOrderRepository.class")
public class DefaultOrderServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final static String ORDERS="orders";
    private final DefaultOrdersService service;
    private final EntityManager manager;

    public DefaultOrderServiceIntegrationTest(DefaultOrdersService service, EntityManager manager) {
        this.service = service;
        this.manager = manager;
    }

    @Test
    void setStatusShipped() {
        service.setStatusShipped(2);
        manager.flush();
        assertThat(countRowsInTableWhere(ORDERS,"id=2 and status='SHIPPED'")).isOne();
    }
    @Test
    void setShippedDate() {
        service.setShippeddate(2);
        manager.flush();
assertThat(jdbcTemplate.queryForObject("select shippeddate from orders where id=2",LocalDate.class)).isEqualTo(LocalDate.now());

    }


}

