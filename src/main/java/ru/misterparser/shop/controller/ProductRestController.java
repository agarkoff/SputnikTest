package ru.misterparser.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.misterparser.shop.domain.Product;
import ru.misterparser.shop.service.ProductService;

import java.util.Collection;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @RequestMapping("/{sku}")
    public Product get(@PathVariable String sku) {
        return productService.get(sku);
    }

    @RequestMapping("/list")
    public Collection<Product> list() {
        return productService.list();
    }

    @RequestMapping(path = "/delete/{sku}", method = RequestMethod.POST)
    public void delete(@PathVariable String sku) {
        productService.delete(sku);
    }

    @RequestMapping(path = "/move/{sku}/{exists}", method = RequestMethod.POST)
    public Product move(@PathVariable String sku, @PathVariable Product.Exists exists) {
        Product product = productService.get(sku);
        productService.move(product, exists);
        return product;
    }
}
