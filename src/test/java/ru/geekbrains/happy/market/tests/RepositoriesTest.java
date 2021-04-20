package ru.geekbrains.happy.market.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.happy.market.model.Product;
import ru.geekbrains.happy.market.repositories.ProductRepository;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class RepositoriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

//    @Test
//    public void genreRepositoryTest() {
//        Genre genre = new Genre();
//        genre.setTitle("Fiction");
//        entityManager.persist(genre);
//        entityManager.flush();
//
//        List<Genre> genresList = genreRepository.findAll();
//
//        Assertions.assertEquals(2, genresList.size());
//        Assertions.assertEquals("Fiction", genresList.get(1).getTitle());
//    }

    @Test
    public void initDbTest() {
        List<Product> genresList = productRepository.findAll();
        Assertions.assertEquals(3, genresList.size());
    }
}
