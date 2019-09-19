package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        // 绑定服务的端口，ip：为本机IP
        // 暴露了一个服务，该服务的地址：本机IP，9999
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket socket = server.accept();

//            // 下载的线程
//            MyDownload download = new MyDownload(socket);
//            // Runnable -> Thread
//            Thread downLoadThread = new Thread(download);
//            downLoadThread.start();

            // 上述3行语句等价于如下语句
            new Thread(new MyDownload((socket))).start();
        }
    }
}
