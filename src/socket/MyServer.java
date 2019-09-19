package socket;

import java.io.*;
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

        /*发送文字hello
        * String info = "hello";
        * String -> byte[]
        * out.write(info.getBytes());
        * */

        // 准备要发送的文件
        File file = new File("C:\\Users\\animation\\Desktop\\3.jpg");
        // 将此文件从硬盘读入到内存
        FileInputStream fileIn = new FileInputStream(file);
        byte[] fileBytes = new byte[100]; // 定义每次发送的文件大小
        // 发送（因为文件较大，不能一次发送完毕，因此需要通过循环来分次发送）
        int len = -1;
        while ((len = fileIn.read(fileBytes)) != -1) {
            out.write(fileBytes, 0, len);
        }


//        // 接收客户端的消息
//        InputStream in = socket.getInputStream();
//        byte[] bs = new byte[100];
//        in.read(bs);
//        System.out.println("接收客户端发来的消息为：" + new String(bs));

        fileIn.close();
        out.close();
//        in.close();
        socket.close();
        server.close();
    }
}
