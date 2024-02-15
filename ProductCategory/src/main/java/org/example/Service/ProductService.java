package org.example.Service;

import org.example.Model.Category;
import org.example.Model.Product;
import org.example.Repository.CategoryRepository;
import org.example.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepo = productRepository;
        this.categoryRepo = categoryRepository;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public void linkProductWithCategory(int productId, int categoryId) {
        Product product = productRepo.findById(productId).get();
        Category category = categoryRepo.findById(categoryId).get();

        product.setCategory(category);
        productRepo.save(product);
    }

    public Product findProductById(int productId) {
        return productRepo.findById(productId).get();
    }

    public Product updateProductById(int id, Product product) {
        Product findProduct = productRepo.findById(id).get();
        if(product.getProductName()!=null) {
            findProduct.setProductName(product.getProductName());
        }
        if(product.getProductDes()!=null) {
            findProduct.setProductDes(product.getProductDes());
        }
        if(product.getProductPrice()!=0) {
            findProduct.setProductPrice(product.getProductPrice());
        }
        if(product.getCategory()!=null) {
            findProduct.setCategory(product.getCategory());
        }
        productRepo.save(findProduct);
        return findProduct;
    }

    public List<Product> getAlProducts() {
        return productRepo.findAll();
    }

    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> getProductByAnyField(Product product) {
        if(product.getProductName().equals(null)) {
            product.setProductName("%");
        }
        if(product.getProductDes().equals(null)) {
            product.setProductDes("%");
        }
        return null;
//        if(product.getProductPrice().equals(null)) {
//            return productRepo.getProductByAnyField(product.getProductName(),product.getProductDes());
//        }
//        return productRepo.getProductByAnyField(product.getProductName(),product.getProductPrice(),product.getProductDes());
    }
}
