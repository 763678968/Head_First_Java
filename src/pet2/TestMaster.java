package pet2;

public class TestMaster {
    public static void main(String[] args) {
        Master master = new Master();

        Dog dog = new Dog();
        dog.setName("wc");
        Penguin penguin = new Penguin();
        penguin.setName("QQ");
//
//        master.feedDog(dog);
//        master.feedPenguin(penguin);

        master.feed(dog);
        master.feed(penguin);

    }
}
