//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索

  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//java:01 矩阵
public class P542Zero1Matrix{
    public static void main(String[] args) {
        Solution solution = new P542Zero1Matrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // 多源BFS
//        int m = matrix.length, n = matrix[0].length;
//        int[][] res = new int[m][n];
//        boolean[][] visited = new boolean[m][n];
//        Queue<int[]> queue = new LinkedList<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(matrix[i][j] == 0){
//                    res[i][j] = 0;
//                    visited[i][j] = true;
//                    queue.offer(new int[]{i,j});
//                }
//            }
//        }
//        int[] dx = {0, 0, 1, -1};
//        int[] dy = {1, -1, 0, 0};
//        while(!queue.isEmpty()){
//            int[] point = queue.poll();
//            int x = point[0], y = point[1];
//            for (int i = 0; i < 4; i++) {
//                int new_x = x + dx[i];
//                int new_y = y + dy[i];
//                if(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n && visited[new_x][new_y] == false){
//                    res[new_x][new_y] = res[x][y] + 1;
//                    visited[new_x][new_y] = true;
//                    queue.offer(new int[]{new_x, new_y});
//                }
//            }
//        }
//        return res;
        // 动态规划
        // 距离 (i, j) 最近的 0 的位置，是在其 「左上，右上，左下，右下」4个方向之一；
        // 因此我们分别从四个角开始递推，就分别得到了位于「左上方、右上方、左下方、右下方」距离 (i, j)(i,j) 的最近的 00 的距离，取 minmin 即可
        // 可以优化成从任意一组对角的2次递推

        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    res[i][j] = 0;
                }
                else{
                    res[i][j] = 1000;
                }
            }
        }
        //从左上角开始递推
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i-1 >= 0)
                    res[i][j] = Math.min(res[i][j], res[i-1][j]+1);
                if(j-1 >= 0)
                    res[i][j] = Math.min(res[i][j], res[i][j-1]+1);
            }
        }
        //从右下角开始递推
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if(i+1 < m){
                    res[i][j] = Math.min(res[i][j], res[i+1][j]+1);
                }
                if(j+1 < n){
                    res[i][j] = Math.min(res[i][j], res[i][j+1]+1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}