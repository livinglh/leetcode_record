package Java多线程;
// 题目: 线程a执行完才开始线程b, 线程b执行完才开始线程
//  join()的作用：主要作用是同步，它可以使得线程之间的并行执行变为串行执行。在A线程中调用了B线程的join()方法时，表示只有当B线程执行完毕时，A线程才能继续执行。
//
//          public void joinDemo(){
//            //....
//            Thread t=new Thread(payService);
//            t.start();
//            //....
//            //其他业务逻辑处理,不需要确定t线程是否执行完
//            insertData();
//            //后续的处理，需要依赖t线程的执行结果，可以在这里调用join方法等待t线程执行结束
//            t.join();
//         }

public class 多线程_A后B后C {
    public static class PrintThread extends Thread{

        PrintThread(String name){
            super(name);
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println(getName() + " : " + i);
            }
        }
    }

    public static void main(String[] args){

        PrintThread t1 = new PrintThread("a");
        PrintThread t2 = new PrintThread("b");
        PrintThread t3 = new PrintThread("c");

        try {

            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
