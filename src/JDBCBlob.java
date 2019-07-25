import java.io.*;
import java.sql.*;

public class JDBCBlob {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PWD = "12241122---qrx";

    // 通过JDBC存储二进制类型（MP3)
    // 设置BLOB类型
    public static void BlobDemo() { // 增删改
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // a.导入驱动，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
            // b.与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);

            String sql = "insert into mymusic values(?, ?)";
            // c.发送sql，执行（增删改）
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);

            File file = new File("D:\\Work\\Exercise\\Java\\Head_First_Java\\Charlie Puth,Selena Gomez - We Don't Talk Anymore.mp3");
            InputStream in = new FileInputStream(file);
            pstmt.setBinaryStream(2, in, file.length());

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

    // 读取二进制文件
    public static void BlobReaderDemo() { // 增删改
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // a.导入驱动，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载具体的驱动类
            // b.与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);

            String sql = "select music from mymusic where id = ?";
            // c.发送sql，执行（查）
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                InputStream in = rs.getBinaryStream("music");
                OutputStream out = new FileOutputStream("src/music.mp3");

                byte[] chs = new byte[100];
                int len = -1;
                while ((len = in.read(chs)) != -1) {
                    out.write(chs, 0, len);
                }
                out.close();
                in.close();
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
        //BlobDemo();
        BlobReaderDemo();
    }
}
