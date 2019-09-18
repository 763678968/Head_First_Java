package pet2;

public class Master {

    // 喂养
    public void feedDog(Dog dog) {
        System.out.println("喂狗粮....");
        dog.eat();
    }

    public void feedPenguin(Penguin penguin) {
        System.out.println("喂鱼...");
        penguin.eat();
    }
}
