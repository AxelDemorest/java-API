package com.coding.javaapi.javaapi;

import com.coding.javaapi.javaapi.dao.CategoryDAO;
import com.coding.javaapi.javaapi.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryDAO categoryService;

    @RequestMapping("/category")
    public @ResponseBody List<Category> index(){
        return categoryService.listAll();
    }

    @GetMapping("/category/{id}")
    public @ResponseBody List<Category> readById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @DeleteMapping("/category/{id}")
    public HttpStatus deleteById(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/category/{id}")
    public HttpStatus updateCategory(@PathVariable int id, @RequestBody Category category){
        categoryService.updateCategory(id, category);
        return HttpStatus.OK;
    }

    @PostMapping("/category")
    public HttpStatus createCategory(@RequestBody Category category){
        categoryService.add(category);
        return HttpStatus.CREATED;
    }

    @GetMapping("/category/orders")
    public List<Category> pagination(@RequestParam(value = "range") String range){
        return categoryService.pagination(range);
    }

    @GetMapping("/category/search")
    public List<Category> searching(@RequestParam(value = "name") String name){
        return categoryService.searching(name);
    }
}
