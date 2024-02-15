package org.example.Controller;

import org.bson.types.ObjectId;
import org.example.Model.Category;
import org.example.Model.Product;
import org.example.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    TokenRestConsumer tokenRestConsumer;
    @Autowired
    UserRestConsumer userRestConsumer;
    @Autowired
    ProductRestConsumer productRestConsumer;
    @Autowired
    CategoryRestConsumer categoryRestConsumer;
    @PostMapping("/user/register")
    public String addUser(@RequestBody User user) {
        return userRestConsumer.addUser(user);
    }
    @GetMapping("/user/getall")
    public List<User> findAllUsers() {
        return userRestConsumer.getAllUsers();
    }

    @PostMapping("/product/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRestConsumer.addProduct(product);
    }

    @GetMapping("/product/products")
    public List<Product> findAllProducts() {
        return productRestConsumer.findAll();
    }
    @PostMapping("/category/add-category")
    public Category addingCategory(@RequestBody Category category) {
        return categoryRestConsumer.addingCategory(category);
    }

    @GetMapping("/category/")
    public List<Category> findAllCategories() {
        return categoryRestConsumer.findAllCategories();
    }
    @PostMapping("/user/login")
    public String loginUser(@RequestBody User user){
        User foundUser = userRestConsumer.userLogin(user);
        ObjectId id = foundUser.getId();
        String gotToken = tokenRestConsumer.getToken(id.toString());
        return "{" +
                "\"message\" :"+"Successfully logged in\",\n"+
                "\"data\" :"+user+",\n"+
                "\"UserName: " + user.getUserName() + "\n"+
                "\"token: " + gotToken+ "\" "+
                "}";
    }
}
