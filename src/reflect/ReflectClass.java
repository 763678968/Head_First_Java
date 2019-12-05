package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 反射逻辑封装在ReflectClass.java中
public class ReflectClass {
    private final static String TAG = "animation.log.ReflectClass";

    // 创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("reflect.Book");
            Object objectBook = classBook.getDeclaredConstructor().newInstance();
            Book book = (Book) objectBook;
            book.setName("反射学习指南1");
            book.setAuthor("animation");
            System.out.println(TAG + "reflectNewInstance book = " + book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("reflect.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("反射学习指南2", "animation");
            Book book = (Book) objectBook;
            System.out.println(TAG + "reflectPrivateConstructor book = " + book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("reflect.Book");
            Object objectBook = classBook.getDeclaredConstructor().newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            System.out.println(TAG + "reflectPrivateField tag = " + tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有方法
    public static void reflectPrivateMethod() {

        try {
            Class<?> classBook = Class.forName("reflect.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.getDeclaredConstructor().newInstance();
            String string = (String) methodBook.invoke(objectBook, 0);
            System.out.println(TAG + "reflectPrivateMethod string = " + string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 反射创建对象
        ReflectClass.reflectNewInstance();

        // 反射私有的构造方法
        ReflectClass.reflectPrivateConstructor();

        // 反射私有属性
        ReflectClass.reflectPrivateField();

        // 反射私有方法
        ReflectClass.reflectPrivateMethod();
    }
}
