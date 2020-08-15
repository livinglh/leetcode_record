package 常用算法.设计模式.工厂方法模式;

public class AppleFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new Apple();
    }
}
