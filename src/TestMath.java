class Father {
    public void eat() {
        System.out.println("父类eat");
    }

    protected Father x1() {
        Father f = new Father();
        return f;
    }

    public void a(int num1, int num2) {

    }

}


class Son extends Father {
    @Override
    public void eat() { // 方法重写
        System.out.println("子类eat");
    }

    public void a() {

    }

    public void a(int num) {

    }

    protected Son x1() {
        Son s = new Son();
        return s;
    }
}

class Math {

    public void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public void add(double num1, int num2) {
        System.out.println(num1 + num2);
    }

    public void add(int num1, double num2) {
        System.out.println(num1 + num2);
    }

    public void add(int num1, int num2, int num3) {
        System.out.println(num1 + num2 + num3);
    }

}

public class TestMath {
    public static void main(String[] args) {
        Son son = new Son();
        son.eat();
    }
}
