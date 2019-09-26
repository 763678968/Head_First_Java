package getclass;

public class Test {
    public static void main(String[] args) {
        Person p = new Person(1, "刘德华");
        System.out.println(p);
        System.out.println(p.getClass());
        System.out.println(p.getClass().getName());
    }
}

class Person {
    int id;
    String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return ("序号: " + id + " 姓名: " + name);
    }
}
