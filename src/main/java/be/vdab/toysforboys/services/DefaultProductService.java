package be.vdab.toysforboys.services;

import be.vdab.toysforboys.exceptions.ProductNietGevondenException;
import be.vdab.toysforboys.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void verlaagQuantityInstockEnInOrder(long id, int orderquantity) {

        productRepository.findByid(id).orElseThrow(ProductNietGevondenException::new).verlaagQuantityInOrder(orderquantity);
        productRepository.findByid(id).orElseThrow(ProductNietGevondenException::new).verlaagQuantityInStock(orderquantity);

    }
}
