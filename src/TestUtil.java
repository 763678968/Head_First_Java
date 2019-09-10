import java.lang.reflect.Method;

public class TestUtil {
    public static void main(String[] args) throws Exception {
        CalculatorTest obj = new CalculatorTest();
        run(obj);
    }

    public static void run(Object obj) throws Exception {
        for (Method m : obj.getClass().getMethods()) {
            Test t = m.getDeclaredAnnotation(Test.class);
            if (t != null && !t.ignore()) {
                m.invoke(obj);
            }
        }
    }
}
