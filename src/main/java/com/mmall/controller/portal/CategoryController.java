package com.mmall.controller.portal;

import com.mmall.pojo.Category;
import com.mmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getChildrenParallelCategory/{id}")
    public List<Category> getChildrenParallelCategory(@PathVariable Integer id) {
        return categoryService.getChildrenParallelCategory(id);
    }
}
