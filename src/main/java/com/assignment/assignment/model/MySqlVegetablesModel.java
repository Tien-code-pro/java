package com.assignment.assignment.model;
import com.assignment.assignment.util.ConnectionHelper;
import com.assignment.assignment.entity.Account;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlVegetablesModel implements VegetablesModel {


    @Override
    public Account save(Account account) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into user " +
                    "(id, userName, password, firstName, lastName, email, phone, address,country,createAt,updatedAt,status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getUserName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getFirstName());
            preparedStatement.setString(5, account.getLastName());
            preparedStatement.setString(6, account.getEmail());
            preparedStatement.setString(7, account.getPhone());
            preparedStatement.setString(8, account.getAddress());
            preparedStatement.setString(9, account.getCountry());
            preparedStatement.setString(10, account.getCreateAt().toString());
            preparedStatement.setString(11, account.getUpdatedAt().toString());
            preparedStatement.setInt(12, account.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from user where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("UserName");
                String password = resultSet.getString("Password");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String address = resultSet.getString("Address");
                String country = resultSet.getString("Country");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreateAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Account account = new Account(id, userName,password ,firstName,lastName,email, phone, address, country,createdAt, updatedAt, status);
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from user where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("UserName");
                String password = resultSet.getString("Password");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String address = resultSet.getString("Address");
                String country = resultSet.getString("Country");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreatedAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                account = new Account(id, userName,password,firstName,lastName, email, phone, address,country, createdAt, updatedAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account update(int id, Account updateAccount) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update user " +
                    "set id = ?, UserName = ?, Password = ?, FirstName = ?, LastName = ?, Email = ?, Phone = ?, Address = ?, Country = ?,CreatedAt = ?, UpdatedAt = ?, status = ? where id = ?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, updateAccount.getId());
            preparedStatement.setString(2, updateAccount.getUserName());
            preparedStatement.setString(3, updateAccount.getPassword());
            preparedStatement.setString(4, updateAccount.getFirstName());
            preparedStatement.setString(5, updateAccount.getLastName());
            preparedStatement.setString(6, updateAccount.getEmail());
            preparedStatement.setString(7, updateAccount.getPhone());
            preparedStatement.setString(8, updateAccount.getAddress());
            preparedStatement.setString(9, updateAccount.getCountry());
            preparedStatement.setString(10, updateAccount.getCreateAt().toString());
            preparedStatement.setString(11, updateAccount.getUpdatedAt().toString());
            preparedStatement.setInt(12, updateAccount.getStatus());
            preparedStatement.setInt(13, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateAccount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update user " +
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
