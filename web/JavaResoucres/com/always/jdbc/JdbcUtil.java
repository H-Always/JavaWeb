package com.always.jdbc;

import java.sql.*;

/**
 * @ClassName: JdbcUtil
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/03 08:11
 * @Version: V1.0
 **/
public class JdbcUtil {

    static {
        try {
            String className = "com.mysql.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获得创建链接
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jw?serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "password";
        return DriverManager.getConnection(url,user,password);
    }


    //关闭连接
    public static void close(Connection connection) {
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /*public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();

        Statement statement = connection.createStatement();


        String sql = "select * from stu";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+"\t"+
                    resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+
                    resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+
                    resultSet.getInt(6)+"\t"+resultSet.getInt(7)+"\t");
        }

    }*/

}
