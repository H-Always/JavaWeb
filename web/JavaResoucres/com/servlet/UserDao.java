package com.servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Save
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/13 10:09
 * @Version: V1.0
 **/
public class UserDao {
    public void save(User user) throws SQLException {
        String sql = "insert into t_user values (null,?,?,?,?,0,now(),now())";
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.executeUpdate();
            System.out.println("成功");
        } finally {
            JdbcUtil.close(connection);
        }

    }


    //查询个体
    public User findByUser(String username, String password) throws SQLException {
        String sql = "select id,username,password,email,phone," +
                "type,created,updated from t_user " +
               "where username=? and password=?";

        Connection connection = null;
        User user = null;

        try {
            connection=JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();


            System.out.println("注册成功！");

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setType(resultSet.getInt("type"));
                user.setCreated(resultSet.getTimestamp("created"));
                user.setUpdated(resultSet.getTimestamp("updated"));
            }

        } finally {
                JdbcUtil.close(connection);
        }

        return user;
    }

    public boolean findByUser(String username) throws SQLException {
        String sql = "select id,username,password,email,phone," +
                "type,created,updated from t_user " +
                "where username=? ";

        Connection connection = null;
        User user = null;

        try {
            connection=JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();



            if (resultSet.next()) {
                System.out.println("该用户已存在！");
                return true;
            } else {
                System.out.println("该用户可以注册！");
                return false;
            }

        } finally {
            JdbcUtil.close(connection);
        }


    }


    //查询所有对象
    public List<User> findAll() throws SQLException {

        List<User> list = new ArrayList<>();

        String sql = "select id,username,password,email,phone,type," +
                "created,updated from t_user";

        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                list.add(mapper(resultSet));
            }

        } finally {
            JdbcUtil.close(connection);
        }

        return list;
    }


    public void delete(int id) throws SQLException {
        String sql = "delete from t_user where id = ?";

        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        } finally {
            JdbcUtil.close(connection);
        }

    }



    public User findById(Integer id) throws SQLException {
        User user = null;
        Connection connection = null;

        String sql = " select id,username,password,email,phone," +
                "type,created,updated from t_user where id = ?";

        try {
            connection = JdbcUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);


            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = mapper(resultSet);
            }

        }finally {
            JdbcUtil.close(connection);
        }

        return user;
    }




    public void update(User user) throws SQLException{
        Connection connection = null;

        try {

            String sql = "update t_user set email = ?,phone = ? where id = ?";

            connection = JdbcUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.executeUpdate();

        } finally {
            JdbcUtil.close(connection);
        }





    }




    //将结果集中数据映射到User对象中
    public User mapper(ResultSet resultSet) throws SQLException {

        return new User(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getInt(6),
                resultSet.getTimestamp(7),
                resultSet.getTimestamp(8));
    }

}
