package com.coding.javaapi.javaapi;

import com.coding.javaapi.javaapi.dao.ProductsDAO;
import com.coding.javaapi.javaapi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsDAO productsService;

    @RequestMapping("/products")
    public @ResponseBody List<Products> index(){
        return productsService.listAll();
    }

    @GetMapping("/products/{id}")
    public @ResponseBody List<Products> readById(@PathVariable int id){
        return productsService.getById(id);
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus  deleteById(@PathVariable int id)
    {
        productsService.delete(id);
        return HttpStatus.NO_CONTENT;
    }
    @PutMapping("/products/{id}")
    public HttpStatus updateProduct(@PathVariable int id, @RequestBody Products products){
        productsService.updateProduct(id, products);
        return HttpStatus.OK;
    }
}
