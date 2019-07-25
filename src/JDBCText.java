import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class JDBCText {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PWD = "12241122---qrx";

    // 通过JDBC存储大文本数据（小说）
    // 设置CLOB类型：setCharacterStream
    public static void TextDemo() { // 增删改
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // a.导入驱动，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
            // b.与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);

            String sql = "insert into mynovel values(?, ?)";
            // c.发送sql，执行（增删改）
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);

            File file = new File("D:\\Work\\Exercise\\Java\\Head_First_Java\\言笑弯弯.txt");
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in, "GBK"); // 转换流可以设置编码
            pstmt.setCharacterStream(2, reader, file.length());

            int count = pstmt.executeUpdate();

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
                if (pstmt != null) pstmt.close(); // 对象、方法
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 读取小说
    public static void TextReaderDemo() { // 增删改
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // a.导入驱动，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
            // b.与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);

            String sql = "select novel from mynovel where id = ?";
            // c.发送sql，执行（查）
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Reader reader = rs.getCharacterStream("novel");
                Writer writer = new FileWriter("src/小说.txt");

                char[] chs = new char[100];
                int len = -1;
                while ((len = reader.read(chs)) != -1) {
                    writer.write(chs, 0, len);
                }
                writer.close();
                reader.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close(); // 对象、方法
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // TextDemo();
        TextReaderDemo();
    }
}
