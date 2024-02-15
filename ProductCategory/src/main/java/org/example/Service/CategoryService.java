package org.example.Service;

import org.example.Model.Category;
import org.example.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Category updateCategory(int id, Category category) {
        Category findCategory = categoryRepo.findById(id).get();
        if(category.getCategoryName()!=(null)) {
            findCategory.setCategoryName(category.getCategoryName());
        }
        if(category.getCategoryDescription()!=(null)) {
            findCategory.setCategoryDescription(category.getCategoryDescription());
        }
        categoryRepo.save(findCategory);
        return findCategory;
    }

    public void deleteCategoryById(int id){
        Category findCategory = categoryRepo.findById(id).get();
        categoryRepo.delete(findCategory);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public List<Category> getCategoryByAnyField(Category category) {
        if(category.getCategoryName().equals(null)){
            category.setCategoryName("%");
        }
        if(category.getCategoryDescription().equals(null)) {
            category.setCategoryDescription("%");
        }
        return null;
//        return categoryRepo.findCategoryByAnyField(category.getCategoryName(),category.getCategoryDescription());
    }
}
