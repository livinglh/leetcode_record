package 常用算法.设计模式.抽象工厂模式;

public class HuaweiFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Computer createComputer() {
        return new HuaweiComputer();
    }
}
