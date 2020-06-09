package 公司真题.腾讯.后台2020;

import java.util.Scanner;
import java.util.Stack;

public class 逛街 {
    // 单调栈
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int[] leftseen = new int[len];  //向前看，包含自身
        for (int i = 0; i < len; i++) {
            leftseen[i] = stack.size() + 1;
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
        }

        stack.clear();
        int[] total = new int[len];
        for (int i = len-1; i >= 0 ; i--) {
            total[i] = leftseen[i] + stack.size();
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
        }

        for (int i = 0; i < len; i++) {
            System.out.print(total[i] + " ");
        }
    }
}
