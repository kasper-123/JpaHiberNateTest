package be.vdab.toysforboys.repositories;


import be.vdab.toysforboys.domain.Products;

import java.util.Optional;

public interface ProductRepository {
    Optional<Products> findByid(long id);
}