package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    long id;
    String name;

    // @Version
    //  private long versie;
    @OneToMany
    @JoinColumn(name = "countryId")
    private Set<Customer> klanten;
    protected Country(){}
    public Country(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Customer> getKlanten() {
        return klanten;
    }
}