public class Person {
    private String name;
    private int age;

    public void showInfo() {
        System.out.println(name + "--" + age);
    }

    public void setName(String n) {
        name = n;
    }

    public void setAge(int a) {
        if (a>=0 && a<=120) {
            age = a;
        } else {
            age = -1; // 标识写错
            System.out.println("年龄有误！");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
