package be.vdab.toysforboys.services;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(DefaultProductService.class)
@ComponentScan(value = "be.vdab.toysforboys.repositories",resourcePattern = "JpaProductRepository.class")

class DefaultProductServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String PRODUCTEN="products";
    private final DefaultProductService service;
    private final EntityManager manager;

    DefaultProductServiceIntegrationTest(DefaultProductService service, EntityManager manager) {
        this.service = service;
        this.manager = manager;
    }

    @Test
    void testVerlaagQuantityInStock(){

        service.verlaagQuantityInstockEnInOrder(1,1);
        manager.flush();
        assertThat(countRowsInTableWhere(PRODUCTEN,"id=1 and quantityInStock=7932")).isOne();
        assertThat(countRowsInTableWhere(PRODUCTEN,"id=1 and quantityInOrder=916")).isOne();

    }



}
