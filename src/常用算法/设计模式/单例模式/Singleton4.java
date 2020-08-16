package 常用算法.设计模式.单例模式;

/*
静态内部类实现单例模式，线程安全

当getInstance方法第一次被调用的时候,它第一次读取SingletonHolder.instance，导致SingletonHolder类得到初始化
而这个类在装载并被初始化的时候，会初始化它的静态域，从而创建Singleton的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性。
 */


public class Singleton4 {
    // 静态初始化器，由JVM来保证线程安全
    private static class SingletonHoler {
        private static Singleton4 instance = new Singleton4();
    }

    private Singleton4(){

    }
    public static Singleton4 getInstance(){
        return SingletonHoler.instance;
    }
}
