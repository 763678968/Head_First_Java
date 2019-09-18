package init;

public class TestStatic {
    public TestStatic() {
        System.out.println("无参构造");
    }

    static { // 静态代码块
        System.out.println("static");
    }

    { // 普通代码块
        System.out.println("普通代码块...");
    }

    public static void main(String[] args) {
        new TestStatic();
        new TestStatic();
        new TestStatic();
    }
}
