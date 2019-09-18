package pet2;

public abstract class Pet {
    private String name;

    public abstract void eat();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
