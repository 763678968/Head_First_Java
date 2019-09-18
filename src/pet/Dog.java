package pet;

public class Dog extends Pet{

    private String strain;
    private String other;

    public Dog(String strain, String other) {
        System.out.println("2个参数的构造方法" + strain + other);
        this.strain = strain;
        this.other = other;
    }

    public Dog(String strain) {
        this("a", "b");
        System.out.println("1个参数的构造方法....");
        this.strain = strain;
    }

    public Dog() {
        super("a", 1, 2); // 调用父类无参构造
//        this("a");
        System.out.println("无参构造");
    }

    //    public void a() {
//        System.out.println("子类 Dog...");
//    }
//
//    public String getStrain() {
//        return strain;
//    }
//
//    public void setStrain(String strain) {
//        this.strain = strain;
//    }

    public void print() {
        System.out.println("print....");
        System.out.println(getName() + "\t" + getHealth() + "\t" + getLove() + "\t" + this.strain + "\t" + this.other);
//        a();
    }
}
