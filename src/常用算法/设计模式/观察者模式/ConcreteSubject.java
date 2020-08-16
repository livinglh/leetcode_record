package 常用算法.设计模式.观察者模式;
/*
具体主题类：实现了抽象主题的通知方法，在主题的内部状态发生变化时，调用该方法通知订阅了主题状态的观察者对象
 */
public class ConcreteSubject extends Subject{
    @Override
    public void notifyObserver(String message) {
        for(Observer obs : observers){
            System.out.println("notify observer " + message + " change...");
            obs.dataChange(message);
        }
    }
}
