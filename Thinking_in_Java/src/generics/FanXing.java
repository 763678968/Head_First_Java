package generics;

public class FanXing {

    TestA a = new TestA("13");
    TestA b = new TestA(123);

    public void getClass1(TestA<?> test) {

    }

    // 报错
//    public void getClass2(TestA<T> test) {
//
//    }

    class TestA<T> {
        private T t;

        public TestA(T key) {
            this.t = key;
        }
    }
}
