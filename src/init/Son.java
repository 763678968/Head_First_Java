package init;

public class Son extends Father {

    static {
        System.out.println("子类static....");
    }

    {
        System.out.println("子类普通代码块....");
    }

    public Son() {
        super();
        System.out.println("子类无参....");
    }
}
