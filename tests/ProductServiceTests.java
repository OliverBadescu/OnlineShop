import org.junit.Test;
import products.model.Product;
import products.service.ProductService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ProductServiceTests {

    ProductService productService;

    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        ProductService productService1 = new ProductService();

        Product product = productService1.findProductById(1);

        assertEquals(1, product.getId());

    }

    @Test

    public void AfisareSiGenerare(){

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy S20",999.99,50);
        products.add(product);
        productService = new ProductService(products);

        productService.afisare();
        int id = productService.generateId();

    }

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){
        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy S20",999.99,50);
        products.add(product);
        productService = new ProductService(products);

        Product product1 = productService.findProductById(1);

        assertEquals(1, product1.getId());

    }

    @Test public void GivenAvailableProductNameCheckIfGetsFound(){

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy S20",999.99,50);
        products.add(product);
        productService = new ProductService(products);

        Product product1 = productService.findByName("Samsung Galaxy S20");

        assertEquals(1, product1.getId());

    }

    @Test

    public void SortareCrescSiDescresc(){

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy S20",999.99,50);
        Product product1 = new Product(2,"Samsung Galaxy S20",1000,50);
        Product product2 = new Product(2,"Samsung Galaxy S20",800,50);
        products.add(product);
        products.add(product1);
        products.add(product2);
        productService = new ProductService(products);

        productService.sortareDupaPretDescrescator();
        productService.sortareDupaPretCrescator();
    }

    @Test

    public void GivenAvailableProductCheckIfGetsDeleted(){

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy S20",999.99,50);
        products.add(product);
        productService = new ProductService(products);

        productService.stergereProdus(product);

        assertNull(productService.findProductById(1));

    }

    @Test

    public void GivenAvailableProductCheckIfGetsAdded(){

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy S20",999.99,50);
        Product product1 = new Product(2,"Samsung Galaxy S20",999.99,50);
        productService = new ProductService(products);

        productService.adaugareProdus(product);
        productService.adaugareProdus(product1);

        assertEquals(1, product.getId());
        assertEquals(null, productService.findProductById(2));

    }

    @Test

    public void PromoPastiSiCraciunSiAnulari(){

        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy S20",999.99,50);
        Product product1 = new Product(2,"Samsung Galaxy S20",999.99,50);
        products.add(product);
        products.add(product1);
        productService = new ProductService(products);

        productService.promoCraciun();
        productService.anularePromoCraciun();
        productService.promoPaste();
        productService.anularePromoPaste();

    }
}
