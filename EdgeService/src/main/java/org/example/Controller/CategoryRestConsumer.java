package org.example.Controller;

import org.example.Model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("productCategory-service/category")
public interface CategoryRestConsumer {
    @PostMapping("/add-category")
    public Category addingCategory(@RequestBody Category category);
    @PostMapping("/update/{id}")
    public Category updateCategoryById(@PathVariable int id, @RequestBody Category category);
    @GetMapping("/")
    public List<Category> findAllCategories();
    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable int id);
    @PostMapping("/getCategoryByField")
    public List<Category> getCategoryByAnyField(@RequestBody Category category);
}
