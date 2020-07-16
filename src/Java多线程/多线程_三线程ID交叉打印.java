package Java多线程;

// 题目：编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
public class 多线程_三线程ID交叉打印 {
    public static class ABCABCABC{
        private int flag = 1;
        public synchronized void printA() {
            for(int i = 0; i < 5; i++){
                while(flag != 1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(Thread.currentThread().getName());
                flag = 2;
                notifyAll();
            }
        }
        public synchronized void printB() {
            for(int i = 0; i < 5; i++){
                while(flag != 2){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(Thread.currentThread().getName());
                flag = 3;
                notifyAll();
            }
        }
        public synchronized void printC() {
            for(int i = 0; i < 5; i++){
                while(flag != 3){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(Thread.currentThread().getName());
                flag = 1;
                notifyAll();
            }
        }
    }

    public static void main(String[] args){
        ABCABCABC abc = new ABCABCABC();
        new Thread(new Runnable() {
            @Override
            public void run() {
                abc.printA();
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                abc.printB();
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                abc.printC();
            }
        },"C").start();
    }
}
