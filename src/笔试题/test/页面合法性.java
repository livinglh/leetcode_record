package 笔试题.test;


import java.util.Scanner;

public class 页面合法性 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int numPage = sc.nextInt();
            int curtime = 0;
            int[] time = new int[numPage];
            for (int j = 0; j < numPage; j++) {
                curtime += sc.nextInt();
                time[j] = curtime;
            }
            int res = 1;
            int mintime = 0, maxtime = 60;
            int curK = 0;
            for (int j = 0; j < numPage; j++) {
                if(time[j] > mintime && time[j] <= maxtime){
                    curK += 1;
                    if(curK > 4){
                        res = 0;
                        break;
                    }
                }else{
                    mintime += 60;
                    maxtime += 60;
                    curK = 1;
                }
            }

            System.out.println(res);

        }
    }

}
