package pet2;

public class TestMaster {
    public static void main(String[] args) {
        Master master = new Master();

//        Dog dog = new Dog();
        Pet dog = Master.getPet(2);
        dog.setName("wc");

//        Penguin penguin = new Penguin();
        Pet penguin = Master.getPet(3);
        penguin.setName("QQ");

        master.play(dog);
        master.play(penguin);

//
//        master.feedDog(dog);
//        master.feedPenguin(penguin);

//        master.feed(dog);
//        master.feed(penguin);

    }
}
