package com.coding.javaapi.javaapi.dao;

import com.coding.javaapi.javaapi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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

    public int add(Products p){
        String sql = "INSERT INTO products (type, rating, name, categoryId) VALUES (?, ?, ?, ?);";
        return jdbcTemplate.update(sql, p.getType(), p.getRating(), p.getName(), p.getCategoryId());
    }
}
