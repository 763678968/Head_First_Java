package inter3;

public class PrinterA implements InkBox, Paper {
    @Override
    public void printColor() {
        System.out.println("黑白...");
    }

    @Override
    public void printSize() {
        System.out.println("A4...");
    }
}
