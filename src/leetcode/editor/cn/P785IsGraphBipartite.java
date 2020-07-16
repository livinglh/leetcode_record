//给定一个无向图graph，当这个图为二分图时返回true。 
//
// 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。 
//
// graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自
//环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。 
//
// 
//
//示例 1:
//输入: [[1,3], [0,2], [1,3], [0,2]]
//输出: true
//解释: 
//无向图如下:
//0----1
//|    |
//|    |
//3----2
//我们可以将节点分成两组: {0, 2} 和 {1, 3}。
// 
//
// 
//
//示例 2:
//输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
//输出: false
//解释: 
//无向图如下:
//0----1
//| \  |
//|  \ |
//3----2
//我们不能将节点分割成两个独立的子集。
// 
//
// 注意: 
//
// 
// graph 的长度范围为 [1, 100]。 
// graph[i] 中的元素的范围为 [0, graph.length - 1]。 
// graph[i] 不会包含 i 或者有重复的值。 
// 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 
// 👍 94 👎 0

  
package leetcode.editor.cn;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

//java:判断二分图
public class P785IsGraphBipartite{
    public static void main(String[] args) {
        Solution solution = new P785IsGraphBipartite().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. BFS
//    public boolean isBipartite(int[][] graph) {
//        //BFS
//        int n = graph.length;
//        int[] visited = new int[n]; //未访问：0 红：1 蓝：-1
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if(visited[i] == 0) {  // 当前节点为着色
//                visited[i] = 1;
//                queue.offer(i);
//                while(!queue.isEmpty()){
//                    int node = queue.poll();
//                    int colnei = visited[node] == 1 ? -1 : 1;
//                    for(int nei : graph[node]){
//                        if(visited[nei] == 0){
//                            visited[nei] = colnei;
//                            queue.offer(nei);
//                        }else if(visited[nei] != colnei){
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }

    // DFS

    private boolean valid = true;
    private int[] visited;
    public boolean isBipartite(int[][] graph) {
        // DFS
        int n = graph.length;
        visited = new int[n];
        for (int i = 0; i < n && valid; i++) {
            if(visited[i] == 0){
                DFS(graph, i, 1);
            }
        }
        return valid;
    }

    public void DFS(int[][] graph, int i, int color){

        visited[i] = color;
        int colnei = visited[i] == 1 ? -1 : 1;
        for(int nei : graph[i]){
            if(visited[nei] == 0){
                DFS(graph, nei, colnei);
                if(valid == false){
                    return;
                }
            }else if(visited[nei] != colnei){
                valid = false;
                return;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}