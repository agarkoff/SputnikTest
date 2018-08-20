package ru.misterparser.shop.service;

import org.springframework.stereotype.Service;
import ru.misterparser.shop.domain.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
public class ProductService {

    private Map<String, Product> products = new ConcurrentSkipListMap<>();

    public ProductService() {
        save(new Product("A1", new BigDecimal(100), Product.Category.VEST, Product.Size.SIZE_42, Product.Color.BLACK, "Описание товара", Product.Exists.SHOP));
        save(new Product("C3", new BigDecimal(100), Product.Category.SHIRT, Product.Size.SIZE_50, Product.Color.GREEN, "Описание другого товара", Product.Exists.WAREHOUSE));
    }

    public void save(Product product) {
        products.put(product.getSku(), product);
    }

    public Product get(String sku) {
        return products.get(sku);
    }

    public Collection<Product> list() {
        return products.values();
    }

    public void delete(String sku) {
        products.remove(sku);
    }

    public void move(Product product, Product.Exists exists) {
        product.setExists(exists);
    }
}
