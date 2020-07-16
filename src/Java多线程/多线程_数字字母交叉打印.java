package Java多线程;
// 题目：写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B…5152Z
public class 多线程_数字字母交叉打印 {

    // 写法一
    public static class Numthread extends Thread {
        private Object obj;
        public Numthread(Object obj){
            this.obj = obj;
        }

        @Override
        public void run(){
            synchronized(obj){
                for (int i = 1; i < 53; i++) {
                    System.out.print(i);
                    if(i % 2 == 0){
                        obj.notify();
                        try{
                            obj.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class Charthread extends Thread {
        private Object obj;
        public Charthread(Object obj){
            this.obj = obj;
        }

        @Override
        public void run(){
            synchronized(obj){
                for (int i = 0; i < 26; i++) {
                    System.out.print((char)('A' + i));
                    obj.notify();
                    try{
                        obj.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Object obj = new Object();
        new Numthread(obj).start();
        new Charthread(obj).start();
    }
    // 写法二
//    public static class Print{
//        private int flag = 1;
//        private int count = 1;
//        public synchronized void printNum(){
//            while(flag != 1){
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.print(2*count-1);
//            System.out.print(2*count);
//            flag = -flag;
//            notify();
//        }
//        public synchronized void printChar(){
//            while(flag != -1){
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.print((char)(count-1+'A'));
//            count ++;
//            flag = -flag;
//            notify();
//        }
//    }
//
//
//    public static void main(String[] args){
//        Print print = new Print();
//        new Thread(()->{
//            for(int i = 0;i<26;i++){
//                print.printNum();
//            }
//        }).start();
//        new Thread(()->{
//            for(int i = 0;i<26;i++){
//                print.printChar();
//            }
//        }).start();
//    }
}
