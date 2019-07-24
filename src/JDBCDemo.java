import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PWD = "12241122---qrx";

    public static void update() { // 增删改
        Connection connection = null;
        Statement stmt = null;

        try {
            // a.导入驱动，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
            // b.与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            // c.发送sql，执行（增删改、查）
            stmt = connection.createStatement();
            String sql = "insert into student values(2, 'ls', 24, 's1')";
            // String sql = "update student set STUNAME='ls' where stuno=1";
            //String sql = "delete from student where stuno=1";
            // 执行SQL
            int count = stmt.executeUpdate(sql); // 返回值表示增删改几条数据
            // d.处理结果
            if (count > 0) {
                System.out.println("操作成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close(); // 对象、方法
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void query() { // 增删改
//        Connection connection = null;
//        Statement stmt = null;
//
//        try {
//            // a.导入驱动，加载具体的驱动类
//            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
//            // b.与数据库建立连接
//            connection = DriverManager.getConnection(URL, USERNAME, PWD);
//            // c.发送sql，执行（增删改、查）
//            stmt = connection.createStatement();
//            String sql = "insert into student values(2, 'ls', 24, 's1')";
//            // String sql = "update student set STUNAME='ls' where stuno=1";
//            //String sql = "delete from student where stuno=1";
//            stmt.executeUpdate(sql);
//            // 执行SQL
//            int count = stmt.executeUpdate(sql); // 返回值表示增删改几条数据
//            // d.处理结果
//            if (count > 0) {
//                System.out.println("操作成功！");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null) stmt.close(); // 对象、方法
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
        update();
    }
}
