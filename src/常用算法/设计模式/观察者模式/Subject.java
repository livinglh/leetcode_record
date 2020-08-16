package 常用算法.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/*
抽象主题：持有订阅了该主题得观察者对象的集合，同时提供了增加、删除观察者对象的方法和主题状态发生变化后的通知方法
 */
public abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();
    //增加观察者
    public void add(Observer observer){
        observers.add(observer);
    }
    //删除观察者
    public void remove(Observer observer){
        observers.remove(observer);
    }

    //通知观察者的抽象方法
    public abstract void notifyObserver(String message);

}
