package be.vdab.toysforboys.repositories;


import be.vdab.toysforboys.domain.Products;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class JpaProductRepository implements ProductRepository {
    private final EntityManager manager;

    public JpaProductRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Products> findByid(long id) {
        return Optional.ofNullable(manager.find(Products.class,id));
    }


}