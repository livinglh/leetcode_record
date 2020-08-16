package 常用算法.设计模式.代理模式;

/*
代理模式：为其他对象提供一种代理以控制对这个对象的访问
 */
public class Main {
    public static void main(String[] args) {
        Company company = new Proxy();
        company.findWorker("java");
    }
}
