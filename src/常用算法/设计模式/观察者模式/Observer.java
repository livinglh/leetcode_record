package 常用算法.设计模式.观察者模式;

/*
抽象观察者类：观察者的抽象类或接口，定义了主题状态发生变化时需要调用的方法
 */
public abstract class Observer {
    public abstract void dataChange(String message);
}
