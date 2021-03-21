package be.vdab.toysforboys.services;


import be.vdab.toysforboys.domain.Country;
import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DefaultCustomerServiceTest {
    private DefaultCustomerService service;
    @Mock
    private CustomerRepository repository;
    private Customer customer1;
    private Country country1;
    @BeforeEach
    void  beforeEach(){
        service=new DefaultCustomerService(repository);
        country1= new Country("test");

        customer1=new Customer("customer1","test","","","",country1,1);

    }
}
