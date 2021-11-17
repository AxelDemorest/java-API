package com.coding.javaapi.javaapi.dao;

import com.coding.javaapi.javaapi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Products> listAll(){
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Products.class));
    }

    public List<Products> getById(int id){
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Products.class), id);
    }

    public void deleteProduct(int id){
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateProduct(int id, Products products){
        String sql = "UPDATE products SET type = ?, rating = ?, name = ?, categoryId = ? WHERE id = ?";
        jdbcTemplate.update(sql, products.getType(), products.getRating(), products.getName(), products.getCategoryId(), id);
    }
}
