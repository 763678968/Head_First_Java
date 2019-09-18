package reflect;

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
        // 修改访问权限:使用反射时，如果因为访问修饰符限制造成异常，可以通过Field.setAccessible(true)
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

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
//        demo01();
        demo02();
    }
}
