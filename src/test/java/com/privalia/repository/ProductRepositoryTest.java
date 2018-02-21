package com.privalia.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.privalia.configuration.RepositoryConfiguration;
import com.privalia.domain.Product;
import com.privalia.repositories.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product product1 = null;
    private Product product2 = null;

    @Rule
    public TestName testName = new TestName();

    Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);

    @Before
    public void setUp() throws Exception {
        product1 = new Product();
        product1.setDescription("Privalia Spring Framework");
        product1.setPrice(new BigDecimal("21.95"));
        product1.setProductId("1232");
        productRepository.save(product1);

        product2 = new Product();
        product2.setDescription("Privalia Spring Framework");
        product2.setPrice(new BigDecimal("23.85"));
        product2.setProductId("1233");
        productRepository.save(product2);
        logger.info("Started test " + testName.getMethodName());
    }

    @After
    public void after(){
        logger.info("Finished test " + testName.getMethodName());
        productRepository.deleteAll();
    }

    @Test
    public void testSaveProduct(){
        Product product = new Product();
        product.setDescription("Privalia Spring Guru Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("4");
        assertNull(product.getId());
        productRepository.save(product);
        assertNotNull(product.getId());
    }

    @Test
    public void testGetAllProducts(){
        Iterable<Product> products = productRepository.findAll();
        long size = products.spliterator().getExactSizeIfKnown();
        assertEquals(size, 2);
    }

    @Test
    public void testModifyProduct(){
        product1.setDescription("New description");
        Product updatedProduct = productRepository.save(product1);
        assertEquals(updatedProduct.getDescription(), "New description");
    }

    @Test
    public void testRemoveProduct(){
        productRepository.delete(product1);
        assertNull(productRepository.findOne(product1.getId()));
    }

    @Test
    public void testFindByProductIdAndPrice(){
        Product found = productRepository.findByProductIdAndPrice("1232", new BigDecimal("21.95"));
        assertNotNull(found.getId());
        assertEquals(found.getProductId(), "1232");
        assertEquals(found.getPrice(), new BigDecimal("21.95"));
    }

    @Test
    public void testFindByProductId(){
        Product found = productRepository.findByProductId("1233");
        assertNotNull(found.getId());
        assertEquals(found.getProductId(), "1233");
    }

    @Test
    public void testFindByDescriptionAndPrice(){
        Product found = productRepository.findByDescriptionAndPrice("Privalia Spring Framework", new BigDecimal("23.85"));
        assertNotNull(found.getId());
        assertEquals(found.getProductId(), "1233");
        assertEquals(found.getDescription(), "Privalia Spring Framework");
        assertEquals(found.getPrice(), new BigDecimal("23.85"));
    }
    @Test
    public void testUpdateProduct(){
        product1.setDescription("hello");
        int rowsAffected = productRepository.updateProduct(product1.getId(), product1.getDescription());
        assertEquals(rowsAffected, 1);

        Product p = productRepository.findOne(product1.getId());
        assertEquals(p.getDescription(), "hello");
        assertEquals(p.getId(),product1.getId());
    }

}
