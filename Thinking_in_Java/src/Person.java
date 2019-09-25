public class Person {
    String name;
    int age;
    String gender;

    public static void main(String[] args) {

        Person p = new Person();
        p.name = "zs";
        p.age = 23;
        p.gender = "男";
        System.out.println(p);
    }

    public String toString() {
        return ("姓名：" + name + " 年龄：" + age + " 性别：" + gender);
    }
}
