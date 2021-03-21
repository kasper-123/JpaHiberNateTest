package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private  long id;
    private  String name;
    private  String streetAndNumber;
    private  String city;
    private  String state;
    private String postalcode;

    @ManyToOne(optional=false)
    @JoinColumn(name = "countryId")
    private Country land;

    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders;

    int version;

    public Customer( String naam, String streetAndNumber, String stad, String staat, String postcode, Country land, int version) {

        this.name = naam;
        this.streetAndNumber = streetAndNumber;
        this.city = stad;
        this.state = staat;
        this.postalcode = postcode;
        this.land = land;
        this.version = version;
        this.orders= new LinkedHashSet<>();
    }
    public Set<Orders> getOrders() {

        return Collections.unmodifiableSet(orders);
    }

    public boolean addOrder(Orders order){
        var toegevoegd = orders.add(order);
        var oudeCustomer =order.getCustomer();
        if(oudeCustomer!= null && !oudeCustomer.equals(this)){
            oudeCustomer.orders.remove(order);

        }
        if(oudeCustomer.equals(this)){
            order.setCustomer(this);
        }
        return toegevoegd;
    }

    public void setLand(Country land) {
        this.land = land;
    }

    protected Customer() {
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return name;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getStad() {
        return city;
    }

    public String getStaat() {
        return state;
    }

    public String getPostcode() {
        return postalcode;
    }

    public Country getLandId() {
        return land;
    }

    public int getVersion() {
        return version;
    }


}