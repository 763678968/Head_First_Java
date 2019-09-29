package generics;

import org.apache.commons.logging.Log;

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

        /**
         * 这个方法显然是有问题的，在编译时会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
             public E setKey(E key){
             this.key = key
             }
         */

        /**
         * 这才是一个真正的泛型方法。
         * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
         * 这个T可以出现在这个泛型方法的任意位置
         * 泛型的数量也可以为任意多个
         *    如：public <T,K> K showKeyName(Generic<T> container){
         *        ...
         *        }
         */
        public <T> T showKeyName(Generic<T> container){
            System.out.println("container key :" + container.getKey());
            T test = container.getKey();
            return test;
        }

        //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
        public void showKeyValue1(Generic<Number> obj){
            System.out.println("泛型测试" + "key value is " + obj.getKey());
        }

        //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
        //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
        public void showKeyValue2(Generic<?> obj){
            System.out.println("泛型测试" + "key value is " + obj.getKey());
        }



    }
}
