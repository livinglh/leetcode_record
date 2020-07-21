package Java多线程;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class 多线程_生产者消费者 {
    static int i = 0;
    static int size = 10;
    static Queue<String> queue = new LinkedList<String>();

    public static void main(String[] args) {

        new Producter("producter[1]").start();
        new Producter("producter[2]").start();
        new Consumer("consumer[1]").start();
        new Consumer("consumer[2]").start();
        new Consumer("consumer[3]").start();

    }

    //生产者
    static class Producter extends Thread{
        private String name;

        public Producter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true){
                synchronized (queue) {
                    while(queue.size()==size){
                        System.out.println("The queue is full! "+name+" is waiting for Consumer");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(name+"：product====>production_"+i);
                    queue.offer("production_" + i);
                    i++;
                    queue.notifyAll();
                }
                try {
                    sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者
    static class Consumer extends Thread{
        private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true){
                synchronized (queue) {
                    while(queue.isEmpty()){
                        System.out.println("The queue is empty! "+name+" is waiting for Producter");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String s = queue.poll();
                    System.out.println(name+"：consume====>"+s);
                    queue.notifyAll();
                }
                try {
                    sleep(new Random().nextInt(3500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
