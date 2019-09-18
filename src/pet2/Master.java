package pet2;

public class Master {

    public void play(Pet pet) { // Dog:盘子 Penguin:游泳
//        pet.playSwimming();
        if(pet instanceof Dog) {
            Dog dog = (Dog)pet;
            dog.playCaching(); // 盘子
        } else if (pet instanceof Penguin) {
            Penguin penguin = (Penguin)pet;
            penguin.playSwimming();
        }
    }

    public void feed(Pet pet) {
        System.out.println("喂..." + pet.getName());
        pet.eat(); // dog.eat() cat.eat()
    }

    // Pet: 1.cat 2.dog 3.penguin
    public static Pet getPet(int typeId) {
        Pet pet = null;

        if (typeId == 1) {
//            Cat cat = new Cat();
            pet = new Cat();
        } else if(typeId == 2) {
//            Dog dog = new Dog();
            pet = new Dog();
        } else {
//            Penguin penguin = new Penguin();
            pet = new Penguin();
        }
        return pet;
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
