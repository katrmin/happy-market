package ru.geekbrains.happy.market.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.happy.market.model.Product;
import ru.geekbrains.happy.market.repositories.ProductRepository;
import ru.geekbrains.happy.market.services.ProductService;

import java.util.Optional;

//@SpringBootTest(classes = {ProductRepository.class, ProductService.class})
@SpringBootTest(classes = ProductService.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        Product demoProduct = new Product();
        demoProduct.setTitle("Snickers");
        demoProduct.setPrice(50);
        demoProduct.setId(10L);

        Mockito
                .doReturn(Optional.of(demoProduct))
                .when(productRepository)
                .findById(10L);

        Product p = productService.findProductById(10L).get();
        Mockito.verify(productRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(10L));
        Assertions.assertEquals("Snickers", p.getTitle());
    }
}
