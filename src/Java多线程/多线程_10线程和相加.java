package Java多线程;
// 题目：编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加
public class 多线程_10线程和相加 {
    public static class SubThread extends Thread{
        int start = 0;
        int sum = 0;
        SubThread(int start){
            this.start = start;
        }

        @Override
        public void run(){
            for (int i = 1; i <= 10; i++) {
                sum += i + start * 10;
            }
            System.out.println(Thread.currentThread().getName() + " " + sum);
        }
    }

    public static void main(String[] args){
        int result = 0;

        for (int i = 0; i < 10; i++) {
            SubThread subthread = new SubThread(i);
            subthread.start();
            try{
                subthread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            result += subthread.sum;
        }
        System.out.println("result:" + result);
    }
}
