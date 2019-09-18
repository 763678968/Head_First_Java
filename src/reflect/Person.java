package reflect;

public class Person implements MyInterface, MyInterface2 {

    private int id;
    private String name;
    private int age;

    public String desc;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void privateMethod() {
        System.out.println("private method...");
    }

    private void privateMethod2(String name) {
        System.out.println("private method2..." + name);
    }

    public static void staticMethod() {
        System.out.println("static method ....");
    }

    @Override
    public void interfaceMethod() {
        System.out.println("interfaceMethod....");
    }

    @Override
    public void interface2Method() {
        System.out.println("interfaceMethod2....");
    }
}
