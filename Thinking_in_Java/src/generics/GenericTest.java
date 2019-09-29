package generics;

public class GenericTest {
    // 这个类是泛型类
    public class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        // 虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        // 这只是类中一个普通的成员方法，只不过它的返回值是在声明泛型类时已经声明过的泛型。
        // 所以在这个方法中才可以继续使用T这个泛型。
        public T getKey() {
            return key;
        }

    }
}
