package 笔试题.华为8_5;

import java.util.Scanner;


/*
3 100 20
10 8 5
5 2 1
20 25 8
160
 */
public class Main3 {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int magicsum = sc.nextInt();
        int savetimesum = sc.nextInt();
        int[] kill = new int[n];
        int[] magic = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            kill[i] = sc.nextInt();
            magic[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        int[] nums = new int[n];
        // 计算可使用次数
        for (int i = 0; i < n; i++) {   // 如果存活时间T能整除冷却时间t，应该取max(T/t,1)，否则取T/t＋1。
            if(savetimesum % time[i] == 0){
                nums[i] = savetimesum / time[i];
            }else{
                nums[i] = savetimesum / time[i] + 1;
            }
        }


//        int[] TIMES = new int[n];
//        dfs(n, magicsum, savetimesum, kill, magic, time, 0, TIMES);
        ans = solve(n, magicsum, kill, magic, nums);
        System.out.println(ans);


    }

    public static int solve(int n, int magicsum, int[] kill, int[] magic, int[] nums) {
        int[] dp = new int[magicsum + 1];
        for (int i = 0; i < n; i++) {
//            for (int j = magicsum; j >= magic[i]; j--) {
//                for (int k = 1; k <= nums[i] && k * magic[i] <= j; k++) { //注意
//                    dp[j] = Math.max(dp[j], dp[j - k * magic[i]] + k * kill[i]);
//                }
//            }

            for (int k = 1; k <= nums[i]; nums[i] -= k, k = k * 2) {
                for (int j = magicsum; j >= k * magic[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - k * magic[i]] + k * kill[i]);
                }
            }
            if (nums[i] > 0) {
                for (int j = magicsum; j >= nums[i] * magic[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i] * magic[i]] + nums[i] * kill[i]);
                }
            }
        }
        return dp[magicsum];
    }

    // 20%
    public static void dfs(int n, int magicsum, int savetimesum, int[] kill, int[] magic, int[] time, int curkill, int[] TIMES) {
        for (int i = 0; i < n; i++) {
            if (TIMES[i] + time[i] <= savetimesum && magicsum >= magic[i]) {
                TIMES[i] += time[i];
                curkill += kill[i];
                ans = Math.max(ans, curkill);
                dfs(n, magicsum - magic[i], savetimesum, kill, magic, time, curkill, TIMES);
                TIMES[i] -= time[i];
                curkill -= kill[i];
            }
        }
    }

}
