package generics;

public class GenericTest2 {

    public void showKeyValue1(Generic<? extends Number> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    public static void main(String[] args) {

        Generic<String> generic1 = new Generic<String>("11111");
        Generic<Integer> generic2 = new Generic<Integer>(2222);
        Generic<Float> generic3 = new Generic<Float>(2.4f);
        Generic<Double> generic4 = new Generic<Double>(2.56);

        GenericTest2 gt2 = new GenericTest2();
        // 这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        // gt2.showKeyValue1(generic1);
    }
}
