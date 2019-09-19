package remote.procedure.call.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 服务中心的具体实现
public class ServerCenter implements Server {

    // map: 服务端的所有可供客户端访问的接口，都注册到该map中
    // key：接口的名字"HelloService" value：真正的HelloService实现
    private static HashMap<String, Class> serviceRegister = new HashMap<>();
    private static int port; // 9999
    // 连接池：连接池中存在多个连接对象，每个连接对象都可以处理一个客户请求
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // isRunning用来表示服务是否已经启动
    private static boolean isRunning = false;

    public ServerCenter(int port) {
        this.port = port;
    }

    // 开启服务端服务
    @Override
    public void start() {

        ServerSocket server = null;
        try {
            server = new ServerSocket();
            server.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }

        isRunning = true; // 服务已经启动
        while(true) {
            // 具体的服务内容：接收客户端请求，处理请求，并返回结果
            // 如果想让多个客户端请求并发执行，需要使用多线程
            System.out.println("start server...");
            // 客户端每次请求一次连接（发出一次请求），则服务端从线程池中获取一个线程对象去处理
            Socket socket = null;
            try {
                socket = server.accept();// 等待客户端连接
            } catch (IOException e) {
                e.printStackTrace();
            }
            executor.execute(new ServiceTask(socket)); // 启动线程，去处理客户请求
        }
    }

    @Override
    public void stop() {
        isRunning = false;
        executor.shutdown();
    }

    @Override
    public void register(Class service, Class serviceImpl) {
        serviceRegister.put(service.getName(), serviceImpl);
    }


    // socket客户端 - socket服务端(Start()、ServiceTask)
    private static class ServiceTask implements Runnable {

        private Socket socket;

        public ServiceTask() {

        }

        public ServiceTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() { // 线程所做的事情
            ObjectOutputStream output = null;
            ObjectInputStream input = null;

            try {

                // 接收到客户端连接及请求，处理该请求
                input = new ObjectInputStream(socket.getInputStream());
                // 因为ObjectInputStream对发送数据的顺序严格要求，因此需要参照发送的数据逐个接收
                String serviceName = input.readUTF();
                String methodName = input.readUTF();
                Class[] parameterTypers = (Class[]) input.readObject(); // 方法的参数类型
                Object[] arguments = (Object[]) input.readObject(); // 方法的参数名
                // 根据客户请求，到map中找到具体的接口
                Class ServiceClass = serviceRegister.get(serviceName); // HelloService

                Method method = ServiceClass.getMethod(methodName, parameterTypers);
                // 执行该方法
                Object result = method.invoke(ServiceClass.newInstance(), arguments);// person.say(参数列表)

                // 将方法执行完毕的返回值传给客户端
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (output != null) output.close();
                    if (input != null) input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
