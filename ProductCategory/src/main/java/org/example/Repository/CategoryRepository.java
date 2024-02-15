package org.example.Repository;

import org.example.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

//    List<Category> findByCategoryName(String categoryName);
//
//    List<Category> findByCategoryDescription(String categoryDescription);
////
//    List<Category> findByCategoryNameAndCategoryDescription(String categoryName, String categoryDescription);
//    @Query(value = "SELECT c FROM Category c WHERE c.categoryName like :categoryName AND c.categoryDescription like :categoryDescription")
//    List<Category> findCategoryByAnyField(String categoryName, String categoryDescription);
}
