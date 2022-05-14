package com.example.buytree.category;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String category);

    @Query("SELECT new com.example.buytree.category.CategoryDto(c.name, c.description, c.offers.size)" + "FROM Category c")
    List<CategoryDto> findAllWithCount();




}
