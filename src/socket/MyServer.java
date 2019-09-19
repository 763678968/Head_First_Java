package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        // 绑定服务的端口，ip：为本机IP
        // 暴露了一个服务，该服务的地址：本机IP，9999
        ServerSocket server = new ServerSocket(9999);
        Socket socket = server.accept();
        System.out.println("与客户端连接成功！");

        // 服务端向客户端发送消息Output
        OutputStream out = socket.getOutputStream();
        String info = "hello";
        // String -> byte[]
        out.write(info.getBytes());

        // 接收客户端的消息
        InputStream in = socket.getInputStream();
        byte[] bs = new byte[100];
        in.read(bs);
        System.out.println("接收客户端发来的消息为：" + new String(bs));

        out.close();
        in.close();
        socket.close();
        server.close();
    }
}
