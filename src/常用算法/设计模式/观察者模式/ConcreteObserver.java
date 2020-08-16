package 常用算法.设计模式.观察者模式;

/*
具体观察者类：抽象观察者的实现类，在收到主题状态变化的信息后执行具体的触发机制
 */
public class ConcreteObserver extends Observer{
    @Override
    public void dataChange(String message) {
        System.out.println("recive message: " + message);
    }
}
