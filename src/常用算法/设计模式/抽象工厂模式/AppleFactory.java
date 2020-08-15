package 常用算法.设计模式.抽象工厂模式;

public class AppleFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public Computer createComputer() {
        return new AppleComputer();
    }
}
