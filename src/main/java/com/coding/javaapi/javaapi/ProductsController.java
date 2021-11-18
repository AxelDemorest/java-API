package com.coding.javaapi.javaapi;

import com.coding.javaapi.javaapi.dao.ProductsDAO;
import com.coding.javaapi.javaapi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.net.URI;

@RestController
public class ProductsController {

    @Autowired
    private ProductsDAO productsService;

    @GetMapping("/products")
    public @ResponseBody List<Products> index(@RequestParam(value = "asc", required=false) String asc, @RequestParam(value = "desc", required=false) String desc){
        if(asc == null && desc == null) {
            return productsService.listAll();
        } else {
            return productsService.sortProducts(asc, desc);
        }
    }

    @GetMapping("/products/{id}")
    public @ResponseBody List<Products> readById(@PathVariable int id){
        return productsService.getById(id);
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteById(@PathVariable int id) {
        productsService.deleteProduct(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/products/{id}")
    public HttpStatus updateProduct(@PathVariable int id, @RequestBody Products products){
        productsService.updateProduct(id, products);
        return HttpStatus.OK;
    }

    @GetMapping("/product")
    public @ResponseBody List<Products>  readByRate(@RequestParam("rating") List<String> rating){
        return productsService.getByRate(rating);
    }

    @PostMapping("/products")
    public HttpStatus createProduct(@RequestBody Products products){
        productsService.add(products);
        return HttpStatus.CREATED;
    }

}
