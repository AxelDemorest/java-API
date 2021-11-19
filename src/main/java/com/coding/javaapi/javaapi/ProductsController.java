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

    /**
     *
     * @param asc
     * @param desc
     * @param name
     * @param rating
     * @param type
     * @return Full list of products || Filter list
     */
    @GetMapping("/products")
    public @ResponseBody List<Products> index(
            @RequestParam(value = "asc", required=false) String asc,
            @RequestParam(value = "desc", required=false) String desc,
            @RequestParam(value = "name", required=false) String name,
            @RequestParam(value = "rating", required=false) String rating,
            @RequestParam(value = "type", required=false) String type
    ){
        if(asc == null && desc == null) {
            return productsService.listAll();
        } else if(name == null && rating == null && type == null) {
            return productsService.filterMultipleValues(name, rating, type);
        } else {
            return productsService.sortProducts(asc, desc);
        }
    }

    /**
     *
     * @param id
     * @return A product with a special id
     */
    @GetMapping("/products/{id}")
    public @ResponseBody List<Products> readById(@PathVariable int id){
        return productsService.getById(id);
    }

    /**
     *
     * @param id
     * @return HttpStatus
     */
    @DeleteMapping("/products/{id}")
    public HttpStatus deleteById(@PathVariable int id) {
        productsService.deleteProduct(id);
        return HttpStatus.NO_CONTENT;
    }

    /**
     *
     * @param id
     * @param products
     * @return HttpStatus
     */
    @PutMapping("/products/{id}")
    public HttpStatus updateProduct(@PathVariable int id, @RequestBody Products products){
        productsService.updateProduct(id, products);
        return HttpStatus.OK;
    }

    /**
     *
     * @param rating
     * @return a list of products between two rating
     */
    @GetMapping("/product")
    public @ResponseBody List<Products>  readByRate(@RequestParam("rating") List<String> rating){
        return productsService.getByRate(rating);
    }

    /**
     *
     * @param products
     * @return HttpStatus
     */
    @PostMapping("/products")
    public HttpStatus createProduct(@RequestBody Products products){
        productsService.add(products);
        return HttpStatus.CREATED;
    }

}
