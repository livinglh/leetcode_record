package 笔试题.拼多多9_1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ans = new int[n][n];
        if(n % 2 == 0){
            int mid = (n-1) / 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i <= mid && j > mid && i < (n-1-j)){
                        ans[i][j] = 1;
                    }else if(i <= mid && j > mid && i > (n-1-j)){
                        ans[i][j] = 8;
                    }else if(i <= mid && j <= mid && i < j){
                        ans[i][j] = 2;
                    }else if(i <= mid && j <= mid && i > j){
                        ans[i][j] = 3;
                    }else if(i > mid && j <= mid && i < (n-1-j)){
                        ans[i][j] = 4;
                    }else if(i > mid && j <= mid && i > (n-1-j)){
                        ans[i][j] = 5;
                    }else if(i > mid && j > mid && i > j){
                        ans[i][j] = 6;
                    }else if(i > mid && j > mid && i < j){
                        ans[i][j] = 7;
                    }
                }
            }
        }else{
            int mid = (n-1) / 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i < mid && j > mid && i < (n-1-j)){
                        ans[i][j] = 1;
                    }else if(i < mid && j > mid && i > (n-1-j)){
                        ans[i][j] = 8;
                    }else if(i < mid && j < mid && i < j){
                        ans[i][j] = 2;
                    }else if(i < mid && j < mid && i > j){
                        ans[i][j] = 3;
                    }else if(i > mid && j < mid && i < (n-1-j)){
                        ans[i][j] = 4;
                    }else if(i > mid && j < mid && i > (n-1-j)){
                        ans[i][j] = 5;
                    }else if(i > mid && j > mid && i > j){
                        ans[i][j] = 6;
                    }else if(i > mid && j > mid && i < j){
                        ans[i][j] = 7;
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
