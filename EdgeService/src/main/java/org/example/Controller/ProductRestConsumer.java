package org.example.Controller;

import org.example.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("productCategory-service/product")
public interface ProductRestConsumer {
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product);

    @PostMapping("/{productId}/{categoryId}")
    public void linkProductWithCategoryId(@PathVariable int productId, @PathVariable int categoryId);
    @PostMapping("/{productId}")
    public Product findProduct(@PathVariable int productId);
    @PostMapping("/update/{id}")
    public Product updateProductById(@PathVariable int id, @RequestBody Product product);
    @GetMapping("/products")
    public List<Product> findAll();
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable int id);
    @PostMapping("/getProductByAnyField")
    public List<Product> getProductByAnyField(@RequestBody Product product);

}
