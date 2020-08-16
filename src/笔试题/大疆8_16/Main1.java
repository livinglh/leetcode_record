package 笔试题.大疆8_16;

import java.util.*;

/*

无向图任意两点间最短距离


4 5
0 1 15
1 2 15
0 3 50
1 3 30
2 3 10
3

40
 */
public class Main1 {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[][] nums = new int[N][N];
        boolean[] visited = new boolean[N];
        Map<Integer, Set<Integer>> map  = new HashMap<Integer, Set<Integer>>(); //记录与其相连的节点
        for (int i = 0; i < N; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < P; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int value = sc.nextInt();
            nums[x][y] = value;
            nums[y][x] = value;
            map.get(x).add(y);
            map.get(y).add(x);
        }
        int target = sc.nextInt();
        visited[0] = true;
        DFS(nums, visited, map, 0, target, 0);
        System.out.println(ans);
    }

    public static void DFS(int[][] nums, boolean[] visited, Map<Integer, Set<Integer>> map, int cur, int target, int sum){
        if(cur == target){
            ans = Math.min(sum, ans);
        }

        if(sum >= ans){
            return;
        }

        if(map.get(cur).contains(target)){
            DFS(nums, visited, map, target, target, sum + nums[cur][target]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[cur][i] != 0 && !visited[i] && cur != i){
                visited[i] = true;
                DFS(nums, visited, map, i, target, sum + nums[cur][i]);
                visited[i] = false;
            }
        }

    }
}