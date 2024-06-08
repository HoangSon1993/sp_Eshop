package com.sondev.Eshop.dao;

import com.sondev.Eshop.entities.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductTypeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class ProductTypeMapper implements RowMapper<ProductType> {
        @Override
        public ProductType mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProductType productTypes = new ProductType();
            productTypes.setId(rs.getInt("Id"));
            productTypes.setName(rs.getString("Name"));
            productTypes.setStatus(rs.getByte("Status"));
            return productTypes;
        }
    }

    public List<ProductType> findAll(){
        return jdbcTemplate.query("SELECT * FROM ProductTypes", new ProductTypeMapper());
    }

    public ProductType findById(int id){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM ProductTypes WHERE Id = ?",
                new Object[]{id},
                new ProductTypeMapper()
        );
    }

    public int save(ProductType productType){
        return jdbcTemplate.update(
                "UPDATE ProductTypes SET Name = ?, Status  = ? WHERE Id = ?",
                productType.getName(), productType.getStatus(), productType.getId()
        );
    }

    public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM ProductTypes WHERE Id = ?", id);
    }
}
