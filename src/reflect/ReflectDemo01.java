package reflect;


public class ReflectDemo01 {

    // 通过反射获取类
    public static void demo01() {
        // 获取反射对象（反射入口）： 1.Class.forName(全类名) 2.类名.class 3.对象.getClass()

        // 1. Class.forName(全类名)
        try {
            Class<?> perClass = Class.forName("reflect.Person");
            System.out.println(perClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 类名.class
        Class<?> perClass2 = Person.class;
        System.out.println(perClass2);

        // 3. 对象.getClass()
        Person per = new Person();
        Class<?> perClass3 = per.getClass();
        System.out.println(perClass3);
    }

    public static void main(String[] args) {
    }
}
