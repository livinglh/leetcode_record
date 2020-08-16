package 常用算法.设计模式.单例模式;
/*
懒汉式：双重校验锁实现单例模式，线程安全

**第一次判断singleton是否为null**
  第一次判断是在Synchronized同步代码块外进行判断，由于单例模式只会创建一个实例，并通过getInstance方法返回singleton对象，所以，第一次判断，是为了在singleton对象已经创建的情况下，避免进入同步代码块，提升效率。

**第二次判断singleton是否为null**
  第二次判断是为了避免以下情况的发生。
    (1)假设：线程A已经经过第一次判断，判断singleton=null，准备进入同步代码块.
    (2)此时线程B获得时间片，犹豫线程A并没有创建实例，所以，判断singleton仍然=null，所以线程B创建了实例singleton。
    (3)此时，线程A再次获得时间片，由于刚刚经过第一次判断singleton=null(不会重复判断)，进入同步代码块，这个时候，我们如果不加入第二次判断的话，那么线程A又会创造一个实例singleton，就不满足的单例模式的要求，所以第二次判断是很有必要的。

**Volatile关键字**
  uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
  1. 为 uniqueInstance 分配内存空间
  2. 初始化 uniqueInstance
  3. 将 uniqueInstance 指向分配的内存地址
  但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
  使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 */
public class Singleton3 {

    private volatile static Singleton3 uniqueInstance;

    private Singleton3() {
    }

    public static Singleton3 getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton3.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton3();
                }
            }
        }
        return uniqueInstance;
    }
}


