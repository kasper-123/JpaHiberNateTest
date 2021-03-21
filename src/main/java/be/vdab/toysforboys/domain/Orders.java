package be.vdab.toysforboys.domain;

import be.vdab.toysforboys.Status;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @DateTimeFormat(style = "S-")
    LocalDate orderDate;

    LocalDate requiredDate;
    LocalDate shippeddate;
    String comments;

    @Enumerated(EnumType.STRING)
    Status status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId")
    @OrderBy("name")
    private Customer customer;


    @ElementCollection
    @CollectionTable(name = "orderdetails",
            joinColumns = @JoinColumn(name = "orderId"))

    private Set<OrderDetails> orderDetails;

    @Version
    private long version;



    protected Orders(){}
    public Orders(LocalDate orderDate, LocalDate requiredDate, LocalDate shippeddate, String comments,Customer customer, Status status,long versie) {
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippeddate = shippeddate;
        this.comments = comments;
        this.customer = customer;
        this.status = status;
        this.orderDetails = new LinkedHashSet<>();
        this.version=versie;
    }

    public long getId() {
        return id;
    }
    public void setShippeddate(){
        this.shippeddate=LocalDate.now();
    }
    public void setStatusShipped(Status status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public LocalDate getShippeddate() {
        return shippeddate;
    }

    public String getComments() {
        return comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Status getStatus() {
        return status;
    }


    public Set<OrderDetails> getOrderDetails() {
        return Collections.unmodifiableSet(orderDetails);
    }

    public void setCustomer(Customer customer) {
        if (customer.getOrders().contains(this)) {
            customer.addOrder(this);
        }
        this.customer=customer;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippeddate=" + shippeddate +
                ", comments='" + comments + '\'' +
                ", status=" + status +
                ", customer=" + customer +
                ", version=" + version +
                '}';
    }

    public long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Objects.equals(orderDate, orders.orderDate) && Objects.equals(customer, orders.customer);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, customer);
    }

    public void setStatusShipped() {
        this.status=Status.SHIPPED;
    }
}
