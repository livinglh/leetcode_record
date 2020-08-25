package 笔试题.猿辅导8_22;

import java.util.Scanner;

public class Main1 {
    static int N;
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        printleft(nums, 1);
        printdown(nums, 1);
        printright(nums,1);
    }

    public static void printleft(int[] nums, int root){
        if(root*2 <= N || root*2+1 <= N){
            System.out.print(nums[root-1] + " ");
            printleft(nums, root*2);
        }
    }
    public static void printdown(int[] nums, int root){
        if(root <= N){
            if(root*2 > N && root*2+1 > N){
                System.out.print(nums[root-1] + " ");
            }
            printdown(nums, root*2);
            printdown(nums, root*2+1);
        }
    }
    public static void printright(int[] nums, int root){
        if(root*2 <= N || root*2+1 <= N){
            printright(nums, root*2+1);
            if(root == 3){
                System.out.print(nums[root-1]);
            }
            else{
                if(root != 1){
                    System.out.print(nums[root-1]+ " ");
                }
            }
        }
    }
}
