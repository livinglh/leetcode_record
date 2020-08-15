package 常用算法.设计模式.工厂方法模式;



public class Main {
    /*
    工厂方法模式：定义一个用于创建接口的对象，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。

    工厂方法模式实现时，客户端需要决定实例化哪一个工厂方法来实现运算类，选择判断的问题还是存在的
    也就是说，工厂方法把简单工厂的内部逻辑判断移到了客户端代码来进行。你想要加功能，本来是改工厂类，而现在是修改客户端

    优点：解决了简单工厂违背开放-封闭原则的问题，又保持了封装对象创建过程的优点
    缺点：每增加一个实现（手机接口的实现类），就要增加一个相应产品工厂的类，增加了额外的开发量；没有避免修改客户端的代码

    优化点：利用“反射”解决分支判断问题
    */
    public static void main(String[] args) {
        Factory factory = new HuaweiFactory();
        Phone huawei = factory.createPhone();
        Factory factory2 = new AppleFactory();
        Phone apple = factory2.createPhone();
        System.out.println(huawei.brand());
        System.out.println(apple.brand());
    }
}
