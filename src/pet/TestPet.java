package pet;

public class TestPet {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.setName("wc");
        dog.setLove(99);
        dog.setHealth(98);
        dog.setStrain("哈士奇");
        dog.print();
    }
}
