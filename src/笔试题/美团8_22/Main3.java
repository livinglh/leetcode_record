package 笔试题.美团8_22;

import java.util.Scanner;

public class Main3 {
    private static final int STOP_SIGNAL = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] weight = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = input.nextInt();
            sum[i] = weight[i];
            if(i!=0){
                sum[i] += sum[i-1];
            }
        }
        int[] orders = new int[n];
        for (int i = 0; i < n; i++) {
            orders[i] = input.nextInt()-1;
        }
        for (int order: orders) {
            int i = order+1;
            while(i<n&&sum[i]!=STOP_SIGNAL){
                sum[i] -= sum[order];
                i++;
            }
            sum[order] = STOP_SIGNAL;
            int maxValue = Integer.MIN_VALUE;
            for (int s : sum) {
                maxValue = Math.max(s,maxValue);
            }
            System.out.println(maxValue);
        }
    }
}
