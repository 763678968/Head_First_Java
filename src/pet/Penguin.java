package pet;

public class Penguin extends Pet{

    private boolean sex;

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void print() {
        System.out.println(getName() + "\t" + getHealth() + "\t" + getLove() + "\t" + this.sex);
    }
}
