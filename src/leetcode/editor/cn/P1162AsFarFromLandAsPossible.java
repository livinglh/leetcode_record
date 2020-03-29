//你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
//你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。 
//
// 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x
//1| + |y0 - y1| 。 
//
// 如果我们的地图上只有陆地或者海洋，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 输入：[[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 不是 0 就是 1 
// 
// Related Topics 广度优先搜索 图

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:地图分析
public class P1162AsFarFromLandAsPossible{
    public static void main(String[] args) {
        Solution solution = new P1162AsFarFromLandAsPossible().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 普通DFS 对每一个0（海洋）位置进行BFS扩展，若遇到1（陆地），返回扩展的次数
//    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
//    public int maxDistance(int[][] grid) {
//        int ans = -1;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if(grid[i][j] == 0){
//                    ans = Math.max(ans, find(i,j,grid,0));
//                }
//            }
//        }
//
//        return ans;
//    }
//    public int find(int i, int j, int[][] grid, int step){
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{i,j});
//        while(!queue.isEmpty()){
//            step ++;
//            int n = queue.size();
//            for (int k = 0; k < n; k++) {
//                int[] temp = queue.poll();
//                int x = temp[0];
//                int y = temp[1];
//                for (int l = 0; l < 4; l++) {
//                    int newx = x + dir[l][0];
//                    int newy = y + dir[l][1];
//                    if(newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length){
//                        continue;
//                    }
//                    if(grid[newx][newy] == 1) return step;
//                    if(!visited[newx][newy]){
//                        visited[newx][newy] = true;
//                        queue.offer(new int[]{newx,newy});
//                    }
//                }
//            }
//        }
//        return -1;
//    }
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                hasOcean = true;
                queue.offer(new int[] {newX, newY});
            }
        }

        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}