package 常用算法.设计模式.简单工厂模式;

public class Main {
    /*
     工厂模式本质上是用工厂方法替代new操作创建一种实例化对象的方法，以提供一种方便地创建有同种类型接口产品的复杂对象
     优点：可维护，可复用，可扩展，灵活性好

     简单工厂模式的最大优点在于工厂类中包含了必要的逻辑判断，根据客户端的选择条件动态实例化相关的类，对于客户端来说，去除了与具体产品的依赖
     缺点：违背了开放-封闭原理，软件实体应该可以扩展，但是不可以修改
      */
    public static void main(String[] args) {
        Factory factory = new Factory();
        Phone huawei = factory.createPhone("huawei");
        Phone apple = factory.createPhone("apple");
        System.out.println(huawei.brand());
        System.out.println(apple.brand());
    }
}
