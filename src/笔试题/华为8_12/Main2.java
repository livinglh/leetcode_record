package 笔试题.华为8_12;

import java.util.Scanner;
/*
2
3 5
1 0 1 0 0
0 1 1 0 1
0 0 1 0 1
 */

public class Main2 {
    static int s, m, n;
    static boolean[][] visited;
    static int[][] nums;
    static int[] dx;
    static int[] dy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        dx = new int[]{s,0,-s,0};
        dy = new int[]{0,s,0,-s};
        visited = new boolean[m][n];
        visited[0][0] = true;
        boolean ans = DFS(0,0);
        System.out.println(ans == true ? 1:0);
    }

    public static boolean DFS(int x, int y){
        if(x == m-1 && y == n-1){
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(nx >= 0 && nx <= m && ny >= 0 && ny <= n && nums[nx][ny] == 1 && visited[nx][ny] == false){
                visited[nx][ny] = true;
                if(DFS(nx,ny)){
                    return true;
                }
                visited[nx][ny] = false;
            }
        }

        return false;
    }
}
