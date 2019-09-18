package pet;

public class Pet {
    private String name;
    private int health;
    private int love;

    public Pet() {
        System.out.println("父类无参构造");
    }

    public Pet(String name, int health, int love) {
        this.name = name;
        this.health = health;
        this.love = love;
        System.out.println("父类有参构造...");
    }

    public void a() {
        System.out.println("父类pet...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }
}
