package com.assignment.assignment.model;


import com.assignment.assignment.entity.myenum.SizeStatus;
import com.assignment.assignment.util.ConnectionHelper;
import com.assignment.assignment.entity.Size;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlSizeModel implements SizeModel{

    @Override
    public Size save(Size size) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into size "+
                    "(name,createdAt,updatedAt,status)"+
                    " value "+"(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,size.getName());
            preparedStatement.setString(2,size.getCreatedAt().toString());
            preparedStatement.setString(3,size.getUpdatedAt().toString());
            preparedStatement.setInt(4,size.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return size;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Size> findAll() {
        List<Size> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from size where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, SizeStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                Size size = new Size(id,name);
                size.setCreatedAt(createdAt);
                size.setUpdatedAt(updatedAt);
                size.setStatus(SizeStatus.of(intstatus));
                list.add(size);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Size findById(int id) {
        Size size = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from size where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,SizeStatus.ACTIVE.getValue());
            preparedStatement.setInt(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                size.setCreatedAt(createdAt);
                size.setUpdatedAt(updatedAt);
                size.setStatus(SizeStatus.of(intstatus));
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return size;
    }



    @Override
    public Size update(int id, Size size) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update size "+
                    "set name = ?, createdAt = ?,updatedAt = ? ,status = ? where  id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,size.getName());
            preparedStatement.setString(2,size.getCreatedAt().toString());
            preparedStatement.setString(3,size.getUpdatedAt().toString());
            preparedStatement.setInt(4,size.getStatus().getValue());
            preparedStatement.setInt(5,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return size;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update size " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,SizeStatus.DELETE.getValue());
            preparedStatement.setInt(2,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
