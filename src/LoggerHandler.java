//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.util.logging.Logger;
//
//public class LoggerHandler implements InvocationHandler {
//    private Object target;
//
//    public LoggerHandler(Object target) {
//        this.target = target;
//    }
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//        Logger.startLog();
//        Object result = method.invoke(target, args);
//        Logger.endLog();
//        return result;
//    }
//}
