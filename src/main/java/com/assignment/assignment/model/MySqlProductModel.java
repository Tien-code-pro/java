package com.assignment.assignment.model;

import com.assignment.assignment.entity.Account;
import com.assignment.assignment.entity.Products;
import com.assignment.assignment.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductsModel{

    @Override
    public Products save(Products products) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into products " +
                    "(id,name,price,image,title,size,qty,rate,mass,CreatedAt,UpdatedAt,status)" +
                    "values " +
                    "(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,products.getId());
            preparedStatement.setString(2,products.getName());
            preparedStatement.setDouble(3,products.getPrice());
            preparedStatement.setString(4,products.getImage());
            preparedStatement.setString(5,products.getTitle());
            preparedStatement.setString(6,products.getSize());
            preparedStatement.setInt(7,products.getQty());
            preparedStatement.setInt(8,products.getRate());
            preparedStatement.setString(9,products.getMass());
            preparedStatement.setString(10,products.getCreateAt().toString());
            preparedStatement.setString(11,products.getUpdatedAt().toString());
            preparedStatement.setInt(12,products.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return products;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Products> findAll() {
        List<Products> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                String title = resultSet.getString("title");
                String size = resultSet.getString("size");
                int qty = resultSet.getInt("qty");
                int rate = resultSet.getInt("rate");
                String mass = resultSet.getString("mass");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreateAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Products products = new Products(id, name,price ,image,title,size, qty, rate, mass,createdAt, updatedAt, status);
                list.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Products findById(int id) {
        Products products = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                String title = resultSet.getString("title");
                String size = resultSet.getString("size");
                int qty = resultSet.getInt("qty");
                int rate = resultSet.getInt("rate");
                String mass = resultSet.getString("mass");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreatedAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                products = new Products(id, name,price,image,title, size, qty, rate,mass, createdAt, updatedAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Products update(int id, Products updateProducts) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products " +
                    "set id = ?, name = ?, price = ?, image = ?, title = ?, size = ?, qty = ?, rate = ?, mass = ?,CreateAt = ?, UpdatedAt = ?, status = ? where id = ?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, updateProducts.getId());
            preparedStatement.setString(2, updateProducts.getName());
            preparedStatement.setDouble(3, updateProducts.getPrice());
            preparedStatement.setString(4, updateProducts.getImage());
            preparedStatement.setString(5, updateProducts.getTitle());
            preparedStatement.setString(6, updateProducts.getSize());
            preparedStatement.setInt(7, updateProducts.getQty());
            preparedStatement.setInt(8, updateProducts.getRate());
            preparedStatement.setString(9, updateProducts.getMass());
            preparedStatement.setString(10, updateProducts.getCreateAt().toString());
            preparedStatement.setString(11, updateProducts.getUpdatedAt().toString());
            preparedStatement.setInt(12, updateProducts.getStatus());
            preparedStatement.setInt(13, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateProducts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
