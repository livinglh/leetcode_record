//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集

  
package leetcode.editor.cn;

import java.util.*;

//java:朋友圈
public class P547FriendCircles{
    public static void main(String[] args) {
        Solution solution = new P547FriendCircles().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
//    public void DFS(int[][] M, int i, boolean[] visited){
//        for (int j = 0; j < M.length ; j++) {
//            if(M[i][j] == 1 && visited[j] != true){
//                visited[j] = true;
//                DFS(M,j,visited);
//            }
//        }
//    }
//
//    public int findCircleNum(int[][] M) {
//        if(M.length == 0) return 0;
//        boolean[] visited = new boolean[M.length];
//        int count = 0;
//        for (int i = 0; i < M.length; i++) {
//            if(visited[i] == true) continue;
//            DFS(M, i,visited);
//            count++;
//        }
//        return count;
//    }

    // BFS
//    public int findCircleNum(int[][] M) {
//        if(M.length == 0) return 0;
//        boolean[] visited = new boolean[M.length];
//        int count = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < M.length; i++) {
//            if(visited[i] == true)  continue;
//            queue.offer(i);
//            while(!queue.isEmpty()){
//                int cur = queue.poll();
//                visited[cur] = true;
//                for (int j = 0; j < M.length; j++){
//                    if(M[cur][j] == 1 && visited[j] == false){
//                        queue.offer(j);
//                    }
//                }
//            }
//            count ++;
//        }
//        return count;
//    }
    //并查集
    public int find(int[] parent, int x){
        if(parent[x] == -1)
            return x;
        return find(parent, parent[x]);
    }
    public void union(int[] parent, int x, int y){
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        if (xroot == yroot) return;
        parent[xroot] = yroot;
    }
    public int findCircleNum(int[][] M) {
        if(M.length==0) return 0;
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1){
                    union(parent,i,j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == -1)
                count += 1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}