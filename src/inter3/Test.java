package inter3;

public class Test {
    public static void main(String[] args) {
        PrinterA a = new PrinterA();
        a.printColor();
        a.printSize();

        PrinterB b = new PrinterB();
        b.printColor();
        b.printSize();
    }
}
