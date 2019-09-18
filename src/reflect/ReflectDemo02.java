package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo02 {
    // 获取对象的示例，并操作对象
    public static void demo01() throws IllegalAccessException, InstantiationException {
        // Class入口
        Class<?> perClass = null;
        try {
            perClass = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person per = (Person) perClass.newInstance();
        per.setName("zs");
        per.setAge(23);
        System.out.println(per.getName() + "," + per.getAge());
    }

    // 操作属性
    public static void demo02() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // Class入口
        Class<?> perClass = null;
        try {
            perClass = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person per = (Person) perClass.newInstance();
        Field idField = perClass.getDeclaredField("id");
        // 访问的是private修饰的id，但是private是私有
        // 修改访问权限:使用反射时，如果因为访问修饰符限制造成异常，可以通过Field/Method/Constructor.setAccessible(true)
        idField.setAccessible(true);
        idField.set(per, 1); // per.setId(1);
        System.out.println(per.getId());

        System.out.println("=========");
        Method method = perClass.getDeclaredMethod("privateMethod", null);
        method.setAccessible(true);
        method.invoke(per, null);

        Method method2 = perClass.getDeclaredMethod("privateMethod2", String.class);
        method2.setAccessible(true);
        method2.invoke(per, "zs");

    }

    // 操作构造方法
    public static void demo03() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Class入口
        Class<?> perClass = null;
        try {
            perClass = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 获取指定的构造方法
        // 在反射中，根据类型获取方法时：基本类型(int, char...)和包装类(Integer, Character)是不同的类型
        Constructor<?> constructor1 = perClass.getConstructor(int.class);
        System.out.println(constructor1);

        Constructor<?> constructor2 = perClass.getDeclaredConstructor(String.class);
        System.out.println(constructor2);

        Constructor<?> constructor3 = perClass.getConstructor();
        Person instance1 = (Person) constructor3.newInstance(); // 因为constructor3是无参构造方法，因此不需要传值
        System.out.println(instance1);

        Person instance2 = (Person) constructor1.newInstance(23); // 因为constructor1是有参构造方法(int)，因此需要传入一个int值
        System.out.println(instance2);

        // 根据获取的private构造方法，获取对象实例
        constructor2.setAccessible(true);
        Person instance3 = (Person) constructor2.newInstance("zs");
        System.out.println("instance3" + instance3);
    }



    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
//        demo01();
//        demo02();
        demo03();
    }
}
