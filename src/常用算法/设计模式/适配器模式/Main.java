package 常用算法.设计模式.适配器模式;

/*
适配器模式：将一个类的接口转换成客户希望的另外一个接口。adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
定义了一个适配器作为两个不兼容接口之间的桥梁
应用：复用一些现存的类，但是接口又与复用环境要求不一致的情况
两种：类适配器模式（需要可以多重继承）和对象适配器模式。此处是对象适配器模式
 */
public class Main {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.request(); //普通请求的接口，实际调用spectificRequest方法
    }
}
