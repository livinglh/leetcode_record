package 笔试题.顺丰8_29;

import java.util.Scanner;

public class Main2 {
    static long value = 0;
    static int weight = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

//        DFS(nums, 0, nums.length-1, k);

        System.out.println(value + " " + weight);

    }

//    public static int DFS(int[] nums, int start, int end, int k, curvalue, ){
//        int n = nums.length;
//        if(k == 1){
//            long sum = 0;
//            for (int i = 0; i < n; i++) {
//                sum += nums[i];
//            }
//            System.out.println(sum * sum + " " + sum);
//        } else if(k == n){
//            long value = 0;
//            int max = 0;
//            for (int i = 0; i < n; i++) {
//                value = nums[i] * nums[i];
//                max = Math.max(nums[i], max);
//                System.out.println(value + " " + max);
//            }
//        } else {
//            int left = 0, right = 0;
//            long cur = 0, max = 0;
//            int ansleft = 0, ansright = 0;
//            for (int i = 0; i < n; i++) {
//                if (cur > 0) {
//                    cur = cur + nums[i];
//                } else {
//                    cur = nums[i];
//                }
//                max = Math.max(cur, max);
//            }
//        }
//    }
}
