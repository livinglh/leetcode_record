package 常用算法.设计模式.单例模式;

// 饿汉式：线程不安全
public class Singleton2 {
    private Singleton2() {

    }

    private static Singleton2 uniqueInstance = new Singleton2();

    public static Singleton2 getSingleton() {
        return uniqueInstance;
    }
}
