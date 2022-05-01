package com.example.buytree.category;

import com.example.buytree.category.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/categories")
@RestController

public class CategoryRestController {


    @GetMapping("/names")
    public List<String> categoryNames() {
        return Arrays.stream(Category.values())
                .map(category -> category.getDisplayName())
                .collect(Collectors.toList());
    }

}
