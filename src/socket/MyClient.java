package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        // 客户端连接Server发布的服务
        Socket socket = new Socket("127.0.0.1", 9999);

        // 接收服务端发送的消息 InputStream
        InputStream in = socket.getInputStream();
        byte[] bs = new byte[100];
        in.read(bs); // 读取发送来的数据
        // byte[] -> String
        System.out.println("client接收到的消息为：" + new String(bs));

        // 客户端向服务端作出反馈（向服务端发送消息）
        OutputStream out = socket.getOutputStream();
        out.write("world".getBytes());

        in.close();
        out.close();
        socket.close();
    }
}
