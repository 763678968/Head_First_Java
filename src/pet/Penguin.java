package pet;

public class Penguin {
    private String name;
    private int health;
    private int love;
    private boolean sex;

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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void print() {
        System.out.println(this.name + "\t" + this.health + "\t" + this.love + "\t" + this.sex);
    }
}
