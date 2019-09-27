package generics;

public class Test1 {
    public static void showKeyValue1(Generic<?> obj) {
        System.out.println("泛型测试 " + "key value is: " + obj.getKey());
    }

    static Generic<Integer> gInteger = new Generic<Integer>(123);
    static Generic<Number> gNumber = new Generic<Number>(456);

    public static void main(String[] args) {
        showKeyValue1(gNumber);
    }
}
