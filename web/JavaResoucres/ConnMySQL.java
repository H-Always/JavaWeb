import java.sql.*;
import java.util.logging.ConsoleHandler;

/**
 * @ClassName: Jdbc_1
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/02 08:33
 * @Version: V1.0
 **/
public class ConnMySQL {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            long start =System.currentTimeMillis();

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job",
                    "root", "password");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

            // 创建Statement对象
            stmt = conn.createStatement();

            // 执行SQL语句
            rs = stmt.executeQuery("select * from emp");
            System.out.println("id\tusername\tpwd\t\tregTime");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
                        + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}