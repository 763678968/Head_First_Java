package pet2;

public class TestMaster {
    public static void main(String[] args) {
        Master master = new Master();

        Dog dog = new Dog();
        Penguin penguin = new Penguin();

        master.feedDog(dog);
        master.feedPenguin(penguin);
    }
}
