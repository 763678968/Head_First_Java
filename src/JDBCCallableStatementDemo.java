import java.sql.*;
import java.util.Scanner;

public class JDBCCallableStatementDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PWD = "12241122---qrx";

    public static void invokeProcedure() { // 增删改
        Connection connection = null;
        CallableStatement cstmt = null;

        try {
            // a.导入驱动，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
            // b.与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);


            // c.发送sql，执行（增删改、查）
            cstmt = connection.prepareCall("{call addTwoNum(?, ?, ?)}");
            cstmt.setInt(1, 10);
            cstmt.setInt(2, 10);
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.execute(); // num1 + num2，execute()之前处理输入参数以及输出参数类型，之后处理输出参数值
            // 设置输出参数的类型

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) cstmt.close(); // 对象、方法
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void query() { // 增删改
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // a.导入驱动，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
            // b.与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            // c.发送sql，执行（增删改、查）
            stmt = connection.createStatement();
//            String sql = "select stuno, stuname from student";

            Scanner input = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name = input.nextLine();
            System.out.println("请输入密码：");
            String pwd = input.nextLine();

            String sql = "select count(*) from login where uname = '"+name+"' and upwd = '"+pwd+"'";

//            String sql = "select * from student where stuname like '%x%'";
            // 执行SQL(增删改executeUpdate()，查询executeQuery())
            rs = stmt.executeQuery(sql); // 返回值表示增删改几条数据
            // d.处理结果
            int count = -1;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            if (count > 0) {
                System.out.println("登陆成功！");
            } else {
                System.out.println("登录失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close(); // 对象、方法
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //update();
        query();
    }
}
