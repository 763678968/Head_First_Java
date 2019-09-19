package socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

// 处理下载的线程
public class MyDownload implements Runnable {

    private Socket socket;

    public MyDownload(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() { // 线程要做什么事 -> 下载

        try {
            System.out.println("与客户端连接成功！");

            // 服务端向客户端发送消息Output
            OutputStream out = socket.getOutputStream();

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

            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
