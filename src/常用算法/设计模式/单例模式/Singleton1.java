package 常用算法.设计模式.单例模式;


// 懒汉式，线程不安全
public class Singleton1 {
    private Singleton1() {

    }

    private static Singleton1 uniqueInstance;

    public static Singleton1 getSingleton() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}
