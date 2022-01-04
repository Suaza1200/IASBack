package com.example.demo.repository;

import com.example.demo.domain.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Component
public class SpringJdbcProductsRepository implements ProductsRepository {
    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> rowMapper = (resultSet, rowNum) -> {
        ProductId productId = ProductId.fromString(
                resultSet.getString("id_number")
        );
        ProductName productName = new ProductName(resultSet.getString("name"));
        BigDecimal price = new BigDecimal(resultSet.getString("price"));
        ProductDescription productDescription = new ProductDescription(resultSet.getString("description"));
        ProductQuantity productQuantity = new ProductQuantity(resultSet.getInt("quantity"));



        return new Product(
                productId,
                productName,
                price,
                productDescription,
                productQuantity
        );
    };


    @Override
    public List<Product> list() {
        String sqlQuery = "select * from products";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Product findOne(ProductId id) {
        String sqlQuery = "select * from products where id_number = ?";

        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
    }

    @Override
    public void create(Product product) {
        String sqlQuery = "insert into products(id_number, name, price, description, quantity) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, product.getId().toString());
            ps.setString(2, product.getName().toString());
            ps.setString(3, product.getPrice().toString());
            ps.setString(4, product.getDescription().toString());
            ps.setInt(5, product.getQuantity().asInteger());
        });
    }

    @Override
    public void update(ProductId id, Product product) {
        String sqlQuery = "update products set price = ?, name = ?, description = ?, quantity = ? where id_number = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, product.getPrice().toString());
            ps.setString(2, product.getName().toString());
            ps.setString(3, product.getDescription().toString());
            ps.setInt(4, product.getQuantity().asInteger());
            ps.setString(5, id.toString());
        });
    }

    @Override
    public void delete(String id) {
        String sqlQuery = "delete from products where id_number = ?";
        jdbcTemplate.update(sqlQuery, id);
    }
}
