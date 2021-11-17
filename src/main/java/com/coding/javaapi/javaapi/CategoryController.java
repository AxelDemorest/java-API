package com.coding.javaapi.javaapi;

import com.coding.javaapi.javaapi.dao.CategoryDAO;
import com.coding.javaapi.javaapi.models.Category;
import com.coding.javaapi.javaapi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDAO categoryService;

    @RequestMapping("/category")
    public @ResponseBody List<Category> index(){
        return categoryService.listAll();
    }

    @GetMapping("/category/{id}")
    public @ResponseBody List<Category> readById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @DeleteMapping("/category/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/category/{id}")
    public HttpStatus updateCategory(@PathVariable Long id, @RequestBody Category category){
        categoryService.updateCategory(id, category);
        return HttpStatus.OK;
    }

    @PostMapping("/category")
    public HttpStatus createCategory(@RequestBody Category category){
        categoryService.add(category);
        return HttpStatus.OK;
    }
}
