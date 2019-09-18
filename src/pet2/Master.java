package pet2;

public class Master {

    public void feed(Pet pet) {
        System.out.println("喂..." + pet.getName());
        pet.eat(); // dog.eat() cat.eat()
    }

//    // 喂养
//    public void feedDog(Dog dog) {
//        System.out.println("喂狗粮....");
//        dog.eat();
//    }
//
//    public void feedPenguin(Penguin penguin) {
//        System.out.println("喂鱼...");
//        penguin.eat();
//    }
}
