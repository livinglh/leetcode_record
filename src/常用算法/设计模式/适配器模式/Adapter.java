package 常用算法.设计模式.适配器模式;

public class Adapter implements Targetable{
    private Source source = new Source();


    // request接口方法实际调用specificRequest方法
    @Override
    public void request() {
        source.specificRequest();
    }
}
