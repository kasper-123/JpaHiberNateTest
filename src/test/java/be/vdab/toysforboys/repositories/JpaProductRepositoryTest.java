package be.vdab.toysforboys.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaProductRepository.class)
class JpaProductRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JpaProductRepository repository;

    public JpaProductRepositoryTest(JpaProductRepository repository) {
        this.repository = repository;
    }

    @Test
    void findById(){
        assertThat(repository.findByid(1).get().getName()).isEqualTo("1969 Harley Davidson Ultimate Chopper");

    }
    @Test
    void findByOnbestaandeId(){
        assertThat(repository.findByid(-2)).isNotPresent();
    }
}
