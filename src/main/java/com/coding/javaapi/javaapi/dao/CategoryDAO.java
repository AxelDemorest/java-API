package com.coding.javaapi.javaapi.dao;

import com.coding.javaapi.javaapi.models.Category;
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
public class CategoryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> listAll(){
        String sql = "SELECT * FROM category";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
    }

    public List<Category> getById(Long id){
        String sql = "SELECT * FROM category WHERE id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class), id);
    }

    public void deleteCategory(Long id){
        String sql = "DELETE FROM category WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateCategory(Long id, Category category){
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, category.getName(), id);
    }

    public void add(Category c) {
        String sql = "INSERT INTO category (name) VALUES (?);";
        jdbcTemplate.update(sql, c.getName());
    }
}

