package be.vdab.toysforboys.domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class OrderDetails {


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId")
    private Products product;

    private int quantityOrdered;
    private BigDecimal priceEach;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderDetails)) return false;
        OrderDetails that = (OrderDetails) o;
        return Objects.equals(product.getId(), that.product.getId());
    }

    public BigDecimal getTotalValue(){
        return priceEach.multiply(BigDecimal.valueOf(quantityOrdered));
    }

    public void setQuantityInProductsAndStock(){
        product.verlaagQuantityInOrder(getQuantityOrdered());
        product.verlaagQuantityInStock(getQuantityOrdered());
    }
    public Products getProduct() {
        return product;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    @Override
    public int hashCode() {
        return (int) product.getId();
    }
}
