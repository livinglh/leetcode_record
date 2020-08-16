package 笔试题.奇安信8_16;

import java.util.Scanner;

public class Main1 {
    public static long ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        backtrace(n);
        System.out.print(ans);
    }

    public static int CalulateMethodCount (int num_money) {
////        // write code here
////        backtrace(num_money);
////        return ans;
        if(num_money == 1){
            return 1;
        }else if(num_money == 2){
            return 2;
        }else if(num_money == 3){
            return 4;
        }else{
            long[] dp = new long[num_money+1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= num_money; i++) {
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])  % 1000000007;
            }
            return (int)dp[num_money];
        }


//        int ans = (int) Math.pow(2, num_money-1);
//        return ans;
//        int ans = 1;
//        if(num_money == 0){
//            return 1;
//        }
//        for (int i = 0; i < num_money; i++) {
//            ans *= 2;
//        }
//
//        return ans;
    }

    public static void backtrace(int n){
        if(n == 0){
            ans += 1;
        }

        for (int i = 1; i <= n; i++) {
            backtrace(n-i);
        }
    }

}

