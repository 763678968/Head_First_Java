package remote.procedure.call.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    // 获取代表服务端接口的动态代理对象(HelloService)
    // serviceName:请求的接口名
    // addr:待请求服务端的ip端口
    @SuppressWarnings("unchecked")
    public static <T> T getRemoteProxyObj(Class serviceInterface, InetSocketAddress addr) {
        /**
         * newProxyInstance(a, b, c)
         * a: 类加载器，需要代理哪个类（例如HelloService接口），就需要将HelloService的类加载器传入第一个参数
         * b: 需要代理的对象，具备哪些方法 --接口
         * 单继承，多实现 A implements B接口, C接口
         * String str = new String();
         * String[] str = new String[]{"aa", "bb", "cc"};
         */

        return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[] {serviceInterface}, new InvocationHandler() {

            /**
             *
             * @param proxy 代理的对象
             * @param method 哪个方法(sayHello(参数列表))
             * @param args 参数列表
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 客户端向服务端发送请求，请求某一个具体的端口
                Socket socket = new Socket();
                ObjectInputStream input = null;
                ObjectOutputStream output = null;

                try {
                    // socketAddress: IP 端口
                    socket.connect(addr);

                    output = new ObjectOutputStream(socket.getOutputStream()); // 发送：序列化流（对象流）
                    // 接口名、方法名：writeUTF
                    output.writeUTF(serviceInterface.getName());
                    output.writeUTF(method.getName());
                    // 方法参数的类型、方法参数：Object
                    output.writeObject(method.getParameterTypes());
                    output.writeObject(args);
                    // 等待服务端处理...
                    // 接收服务端处理后的返回值
                    input = new ObjectInputStream(socket.getInputStream());
                    return input.readObject(); // 客户端 -> 服务端 -> 返回值
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    try {
                        if (output != null) output.close();
                        if (input != null) input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

}
