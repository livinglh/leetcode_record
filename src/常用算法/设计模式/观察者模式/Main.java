package 常用算法.设计模式.观察者模式;

/*
观察者模式：观察者模式又叫做发布-订阅模式
定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主体对象。这个主体对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己

组成部分：抽线主题，具体主题，抽象观察者，具体观察者

应用场景：当一个对象的改变需要同时改变其他对象的时候，而且它不知道具体由多少对象有待改变时，应该考虑使用观察者模式
观察者模式所做的工作其实就是在接触耦合，让耦合的双方都依赖于抽象，而不是依赖于具体。从而使得各自的变化都不会影响到另一边的变化

优化点：观察者在接收到通知后，可能会调用不同的方法，可以使用事件通知机制

 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.add(observer);
        subject.notifyObserver("data");
    }
}
