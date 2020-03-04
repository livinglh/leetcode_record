//给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 说明: 
//
// m 和 n 都是小于110的整数。每一个单位的高度都大于 0 且小于 20000。 
//
// 
//
// 示例： 
//
// 给出如下 3x6 的高度图:
//[
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
//
//返回 4。
// 
//
// 
//
// 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。 
//
// 
//
// 
//
// 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。 
// Related Topics 堆 广度优先搜索

  
package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//java:接雨水 II
public class P407TrappingRainWaterIi{
    public static void main(String[] args) {
        int [][] map = {
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}
            };
        Solution solution = new P407TrappingRainWaterIi().new Solution();
        solution.trapRainWater(map);
    }
//leetcode submit region begin(Prohibit modification and deletion)
//思路：想象为周围水平面逐渐升高
//优先级队列，BFS
    class Node{
        int x;
        int y;
        int h;
        public Node(int x,int y,int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    class Solution {
        public int trapRainWater(int[][] heightMap) {
            if(heightMap.length < 2 || heightMap[0].length < 2) return 0;
            int rows = heightMap.length;
            int cols = heightMap[0].length;
            boolean[][] visited = new boolean[rows][cols]; //标记数组
            Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.h - o2.h; //从小往大
                }
            });
            //将四周的点添加至优先级队列queue，并做标记
            for (int i = 0; i < rows ; i++) {
                queue.offer(new Node(i,0, heightMap[i][0]));
                visited[i][0] = true;
                queue.offer(new Node(i,cols-1, heightMap[i][cols-1]));
                visited[i][cols-1] = true;
            }
            for (int j = 1; j < cols-1; j++) {
                queue.offer(new Node(0,j,heightMap[0][j]));
                visited[0][j] = true;
                queue.offer(new Node(rows-1,j, heightMap[rows-1][j]));
                visited[rows-1][j] = true;
            }

            int sum = 0;//总水量
            int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};//方向数组
            while(!queue.isEmpty()){
                Node node = queue.poll();
                int x = node.x; int y = node.y; int h = node.h;
                for (int i = 0; i < 4; i++) { //向四个方向扩展
                    int new_x = x + dir[i][0];
                    int new_y = y + dir[i][1];
                    if(new_x < 0 || new_x > rows-1 || new_y < 0 || new_y > cols-1
                            || visited[new_x][new_y]){
                        continue; //当新扩展点超出边界或已加入队列
                    }
                    if(h > heightMap[new_x][new_y]){ //当新扩展点的高度小于当前点时
                        sum += h - heightMap[new_x][new_y];
                        heightMap[new_x][new_y] = h;
                    }
                    visited[new_x][new_y] = true;
                    queue.offer(new Node(new_x,new_y,heightMap[new_x][new_y]));
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}