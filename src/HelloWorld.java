import java.util.logging.Logger;

interface IHelloWorld {
    public void sayHello();
}

public class HelloWorld implements IHelloWorld {
    public void sayHello() {
        System.out.println("hello world");
    }
}