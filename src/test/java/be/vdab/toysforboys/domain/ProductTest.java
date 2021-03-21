package be.vdab.toysforboys.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ProductTest {
    private Products product1;

    @BeforeEach
    void beforeEach(){
        product1= new Products("bb","d","dd",2,2, BigDecimal.ONE,1l);
    }

    @Test
    void verlaagQuantityInOrder(){
        product1.verlaagQuantityInOrder(1);
        assertThat(product1.quantityInOrder).isEqualTo(1);

    }
    @Test
    void verlaagQuantityInOrderMetTeveel(){

        assertThatIllegalArgumentException().isThrownBy(()-> product1.verlaagQuantityInOrder(5));


    }

    @Test
    void verlaagQuantitYmetnegatiefl(){

        assertThatIllegalArgumentException().isThrownBy(()-> product1.verlaagQuantityInOrder(-9));
    }

    @Test
    void verlaagQuantityInstock(){
        product1.verlaagQuantityInStock(1);
        assertThat(product1.quantityInStock).isEqualTo(1);

    }
    @Test
    void verlaagQualintyInOrderMetTeveel(){

        assertThatIllegalArgumentException().isThrownBy(()-> product1.verlaagQuantityInStock(5));


    }

    @Test
    void verlaagQualintYmetnegatiefl(){

        assertThatIllegalArgumentException().isThrownBy(()-> product1.verlaagQuantityInStock(-9));
    }

}
