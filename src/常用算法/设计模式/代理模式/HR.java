package 常用算法.设计模式.代理模式;


// 被代理者
public class HR implements Company {
    @Override
    public void findWorker(String title) {
        System.out.println("i need find a worker, title is: " + title);
    }
}
