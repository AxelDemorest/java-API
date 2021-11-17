package com.coding.javaapi.javaapi;

import com.coding.javaapi.javaapi.dao.ProductsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @Autowired
    private ProductsDAO productsService;

    @RequestMapping("/products")
    public String index(Model model){
        model.addAttribute("listUsers", productsService.listAll());
        return "index";
    }
}
