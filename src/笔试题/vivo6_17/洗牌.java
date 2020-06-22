package 笔试题.vivo6_17;

import java.util.Arrays;
import java.util.Scanner;

public class 洗牌 {
    // 建议用栈
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int mid = N % 2 == 0 ? N / 2 - 1 : N / 2;
        int first = N % 2 == 0 ? N / 2 - 1 : N / 2;
        int last = N-1;
        int index = N-1;
        int K = sc.nextInt();
        int[] work = new int[N];
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            work[i] = sc.nextInt();
        }
        for (int i = 1; i <= K; i++) {
            if(i % 2 == 0){
                while(index >= 0){
                    temp[index--] = work[first--];
                    if(index == -1) break;
                    temp[index--] = work[last--];
                }
            }else{
                while(index >= 0){
                    if(last != mid) temp[index--] = work[last--];
                    if(index == -1) break;
                    temp[index--] = work[first--];
                }
            }
            System.arraycopy(temp, 0, work, 0, work.length);
            first = N % 2 == 0 ? N / 2 - 1 : N / 2;
            last = N-1;
            index= N-1;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(work[i]);
        }

    }
}
