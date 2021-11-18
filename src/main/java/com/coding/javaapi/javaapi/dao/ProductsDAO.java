package com.coding.javaapi.javaapi.dao;

import com.coding.javaapi.javaapi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void add(Products p) {
        String sql = "INSERT INTO products (type, rating, name, categoryId) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, p.getType(), p.getRating(), p.getName(), p.getCategoryId());
    }

    public List<Products> sortProducts(String asc, String desc) {
        String sql = "";

        if(asc != null) {
            switch (asc) {
                case "name":
                    sql = "SELECT * FROM products ORDER BY name ASC";
                    break;
                case "type":
                    sql = "SELECT * FROM products ORDER BY type ASC";
                    break;
                case "rating":
                    sql = "SELECT * FROM products ORDER BY rating ASC";
                    break;
                default:
                    asc = null;
                    break;
            }
        }

        if(desc != null) {
            switch (desc) {
                case "name":
                    if(asc != null) sql += ",name DESC";
                    else sql = "SELECT * FROM products ORDER BY name DESC";
                    break;
                case "type":
                    if(asc != null) sql += ",type DESC";
                    else sql = "SELECT * FROM products ORDER BY type DESC";
                    break;
                case "rating":
                    if(asc != null) sql += ",rating DESC";
                    else sql = "SELECT * FROM products ORDER BY rating DESC";
                    break;
            }
        }


        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Products.class));
    }
}
