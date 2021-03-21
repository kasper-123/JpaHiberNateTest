package be.vdab.toysforboys.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Products {

    @Id
    long id;
    String name;
    String scale;
    String description;
    int quantityInStock;
    int quantityInOrder;
    BigDecimal buyPrice;
    Long productlineId;

    public Products(String name, String scale, String description, int quantityInStock, int quantityInOrder, BigDecimal buyPrice, Long productlineId) {
        this.name = name;
        this.scale = scale;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.quantityInOrder = quantityInOrder;
        this.buyPrice = buyPrice;
        this.productlineId = productlineId;
    }
    protected Products(){}
    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public int getQuantityInOrder() {
        return quantityInOrder;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void verlaagQuantityInOrder(int quantity) {

        if (quantity<0  || (this.quantityInStock -quantity) <0){
            throw new IllegalArgumentException();
        }
        this.quantityInOrder -= quantity ;
    }

    public void verlaagQuantityInStock(Integer quantity) {

        if ((quantity<0 || (this.quantityInStock-quantity)<0)) {
            throw new IllegalArgumentException();
        }
        this.quantityInStock -= quantity;
    }


    public Long getProductlineId() {
        return productlineId;
    }

    public BigDecimal getValue(){
        return buyPrice.multiply(BigDecimal.valueOf(quantityInOrder));
    }

    public String getName() {
        return name;
    }

    public String getScale() {
        return scale;
    }
}