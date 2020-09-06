package 笔试题.网易9_5;

import java.util.Scanner;

/*
1
8
0 1
0 1
3 1
3 1
1 1
1 1
2 1
0 1
 */

// 0
public class Main03 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] nums = new int[100][100];
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int si = 50, sj = 50;
        nums[si][sj] = 1;
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            for (int j = 0; j < N; j++) {
                int dir = sc.nextInt();
                int ans = sc.nextInt();
                if(ans == 1){
                    si += dx[dir];
                    sj += dy[dir];
                    nums[si][sj] = 1;
                    if(j == N-1){
                        nums[si][sj] = 2;
                    }
                }
            }
        }

        DFS(50,50, 0);
        System.out.println(res);
    }

    public static void DFS(int si, int sj, int cur){
        if(!cheack(si,sj)){
            return;
        }
        if(cur > res || nums[si][sj] == 0){
            return;
        }
        if(nums[si][sj] == 2){
            res = Math.min(res, cur);
            return;
        }

        for (int i = 0; i < 4; i++) {
            nums[si][sj] = 0;
            DFS(si + dx[i], sj + dy[i], cur+1);
            nums[si][sj] = 1;
        }
    }

    public static boolean cheack(int i, int j){
        if(i < 0 || i >= nums.length || j < 0 || j >= nums[0].length){
            return false;
        }
        return true;
    }
}
