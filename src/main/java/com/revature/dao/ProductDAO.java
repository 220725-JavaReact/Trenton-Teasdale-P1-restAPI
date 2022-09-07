package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Product;
import com.revature.utils.ConnectionUtil;

public class ProductDAO implements DAO<Product>{

    @Override
    public Product addInstance(Product instance) {
        String sql = "insert into Products(product_name,price,quantity,url) values(?,?,?,?) returning productid";
        try (Connection conn = ConnectionUtil.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, instance.getName());
            stmt.setDouble(2, instance.getPrice());
            stmt.setInt(3, instance.getQuantity());
            stmt.setString(4, instance.getUrl());

            ResultSet rs = stmt.executeQuery();
            rs.next();
            instance.setProductId(rs.getInt("productid"));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }

    @Override
    public List<Product> getAllInstances() {
        String sql = "select * from Products";
        List<Product> listOfProducts = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                listOfProducts.add(new Product(
                    rs.getInt("productid"),
                    rs.getString("product_name"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getString("url")
                ));
            }
            return listOfProducts;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Product updateInstance(Product instance) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product deleteInstance(Product instance) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
