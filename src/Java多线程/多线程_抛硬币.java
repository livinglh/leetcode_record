package Java多线程;

import java.text.DecimalFormat;

// 编写一个Java程序,该程序将启动4个线程,其中3个是掷硬币线程,1个是主线程。
// 每个掷硬币线程将连续掷出若干次硬币(10次以内,次数随机生成);
// 主线程将打印出正面出现的总次数以及正面出现的概率。
public class 多线程_抛硬币 {
    public static class Coin implements Runnable{
        private int num;//随机的硬币数量
        private int positiveNum;//正面数量

        @Override
        public void run() {
            //随机产生硬币数量
            num =  (int)(Math.random() * 10+1);
            //模拟掷硬币
            for(int i = 0;i<this.num;i++) {
                int result = Math.random()>0.5 ? 1:0;
                if(result == 1) {//抛到正面
                    positiveNum += 1;
                }
            }
        }
        public int getNum() {
            return num;
        }
        public int getPositiveNum() {
            return positiveNum;
        }
    }

    public static void main(String[] args) {
        int positiveNum = 0;//正面次数
        int totalNum = 0;//总次数

        //创建三个子线程
        Thread[] ts = new Thread[3];
        Coin[] coins = new Coin[3];
        for(int i=0;i<3;i++) {
            coins[i] = new Coin();
            ts[i] = new Thread(coins[i]);
            ts[i].start();
        }
        //主线程等待子线程执行完毕再统计硬币数
        try {
            ts[0].join();
            ts[1].join();
            ts[2].join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //统计
        for(int i =0;i<3;i++) {
            positiveNum +=coins[i].getPositiveNum();
            totalNum +=coins[i].getNum();
        }
        //保留两位小数
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        float number = (float)positiveNum/(float)totalNum;//求正面概率
        String probability = df.format(number);
        System.out.println("掷硬币总次数："+totalNum+"正面出现的总次数是："+positiveNum+"次,正面出现的概率是："+probability);
    }
}
