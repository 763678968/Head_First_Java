package test;

import test2.C;

public class A extends C {
    public void aMethod() {
        B b = new B();
        System.out.println(b.bField);
        System.out.println(b.bField2);

        C c = new C();
        System.out.println(cField);

    }

    public static void main(String[] args) {
        A a = new A();
        a.aMethod();
    }
}
