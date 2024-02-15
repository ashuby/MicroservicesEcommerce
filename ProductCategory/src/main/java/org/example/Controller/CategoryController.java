package org.example.Controller;

import org.example.Model.Category;
import org.example.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryServ;

    @PostMapping("/add-category")
    public Category addingCategory( @RequestBody Category category) {
//        System.out.println("Category to add api is hit.");
        Category category1= categoryServ.addCategory(category);
        return category1;
    }

    @PostMapping("/update/{id}")
    public Category updateCategoryById(@PathVariable int id, @RequestBody Category category) {
        return categoryServ.updateCategory(id, category);
    }

    @GetMapping("/")
    public List<Category> findAllCategories() {
        return categoryServ.getAllCategories();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable int id) {
        categoryServ.deleteCategoryById(id);
    }

    @PostMapping("/getCategoryByField")
    public List<Category> getCategoryByAnyField(@RequestBody Category category) {
        return categoryServ.getCategoryByAnyField(category);
    }
}
