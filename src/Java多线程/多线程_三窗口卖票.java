package Java多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 题目：三个窗口同时卖票
public class 多线程_三窗口卖票 {

//     写法一 使用synchronized同步代码块
    public static class SaleWindows extends Thread{

        public SaleWindows(String name) {
            super(name);
        }

        static int tickers=1;
        static Object ob= new Object();//指定一个共用对象

        //重写run操作，实现卖票
        @Override
        public void run() {
            // TODO Auto-generated method stub
//            super.run();
            while (tickers <= 20) {
                synchronized (ob) {
                    if (tickers <= 20) {
                        System.out.println(getName() + ":卖出了第" + tickers + "张票");
                        tickers++;
                    } else {
                        System.out.println("票卖完了");
                    }
                }
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){

        SaleWindows windows1 = new SaleWindows("窗口1");
        SaleWindows windows2 = new SaleWindows("窗口2");
        SaleWindows windows3 = new SaleWindows("窗口3");

        windows1.start();
        windows2.start();
        windows3.start();
    }

    // 写法二： 使用ReentrantLock()
//    public static class SaleWindows implements Runnable {
//        private static int tickers = 1;
//        ReentrantLock reentrantLock = new ReentrantLock();
//        @Override
//        public void run() {
//            while(tickers <= 20){
//                reentrantLock.lock();
//                try{
//                    if(tickers <= 20){
//                        Thread.sleep(100);
//                        System.out.println(Thread.currentThread().getName() + ":卖出了第" + tickers + "张票");
//                        tickers++;
//                    }else{
//                        System.out.println("票卖完了");
//                        break;
//                    }
//
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }finally {
//                    reentrantLock.unlock();
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SaleWindows saleWindows = new SaleWindows();
//
//        Thread thread1 = new Thread(saleWindows, "窗口1");
//        Thread thread2 = new Thread(saleWindows, "窗口2");
//        Thread thread3 = new Thread(saleWindows, "窗口3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//    }
}
