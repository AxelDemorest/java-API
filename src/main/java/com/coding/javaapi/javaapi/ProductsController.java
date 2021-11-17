package com.coding.javaapi.javaapi;

import com.coding.javaapi.javaapi.dao.ProductsDAO;
import com.coding.javaapi.javaapi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.rmi.server.ServerCloneException;
import java.util.List;
import java.net.URI;

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

    @PostMapping("/products")
    public ResponseEntity.BodyBuilder createProduct(@RequestBody Products products){
        int res = productsService.add(products);
        if (res == 1) {
            return ResponseEntity.created(URI.create("/products"));
        }
        else{
            return ResponseEntity.badRequest();
        }

    }
}
