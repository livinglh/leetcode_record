package Java多线程;
// 题目：两个线程轮流打印数字，一直到100
public class 多线程_轮流打印数字 {
    public static void main(String[] args) {
        System.out.println("++++++线程++++++");
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1：");
        t2.setName("线程2：");
        t1.start();
        t2.start();
    }

    public static class Number implements Runnable {
        private int number = 1;
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    this.notifyAll();
                    if (number <= 100) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + number);
                        number++;
                        try {
                            //使得调用wait() 方法线程进入阻塞状态
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
