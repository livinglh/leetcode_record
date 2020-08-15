package 常用算法.设计模式.抽象工厂模式;

public class Main {
    /*
    抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们的具体类

    优点：隔离了具体类的生产，使得客户并不需要知道什么被创建
    缺点：若是需要增加一个产品（如汽车），则需要增加多个产品类，同时还需要修改Factory接口以及各实现类

    可以使用简单工厂来改进抽象工厂
    可以使用反射+配置文件进行优化
     */

    public static void main(String[] args) {
        Factory huaweiFactory = new HuaweiFactory();
        Phone huaweiPhone = huaweiFactory.createPhone();
        Computer huaweiComputer  = huaweiFactory.createComputer();
        System.out.println(huaweiPhone.call());
        System.out.println(huaweiComputer.internet())  ;
        Factory appleFactory = new AppleFactory();
        Phone applePhone = appleFactory.createPhone();
        Computer appleComputer = appleFactory.createComputer();
        System.out.println(applePhone.call());
        System.out.println(appleComputer.internet());
    }
}
