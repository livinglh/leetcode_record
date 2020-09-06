package 笔试题.字节9_6;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N+1];
        int[] R = new int[N+1];
        int[] L = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        // 构建R数组
        Stack<Integer> stackR = new Stack<>();
        stackR.push(1);
        for (int i = 2; i <= N; i++) {
            while(!stackR.isEmpty() && nums[i] > nums[stackR.peek()]){
                R[stackR.peek()] = i;
                stackR.pop();
            }
            stackR.push(i);
        }

        // 构建L数组
        Stack<Integer> stackL = new Stack<>();
        stackL.push(N);
        for (int i = N - 1; i > 0; i--) {
            while(!stackL.isEmpty() && nums[i] > nums[stackL.peek()]){
                L[stackL.peek()] = i;
                stackL.pop();
            }
            stackL.push(i);
        }

        // 求max
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, L[i] * R[i]);
        }
        System.out.println(max);
    }
}
