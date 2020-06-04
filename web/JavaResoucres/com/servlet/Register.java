package com.servlet;

import com.servlet.JdbcUtil;

import java.sql.*;

/**
 * @ClassName: Register
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/03 08:57
 * @Version: V1.0
 **/
public class Register {
    public static void main(String[] args) {
        String userName = "马云";
        String address = "杭州";

        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            //String sql = "select * from stu where name ='"+userName+"' and address = '"+address+"' ";
            String sql = "select * from t_user where name =? and address = ?";

            //Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,address);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                System.out.println("登录成功，用户信息如下:");

                System.out.println(resultSet.getInt(1)+"\t"+
                        resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+
                        resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+
                        resultSet.getInt(6)+"\t"+resultSet.getInt(7)+"\t");
            }else{
                System.out.println("用户不存在");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connection);

        }

    }
}
