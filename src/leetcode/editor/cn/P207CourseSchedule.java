//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 410 👎 0


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:课程表
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //问题本质： 课程安排图是否是 有向无环图
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            // 法1： BFS
//            //1. 建立入度表和邻接矩阵
//            int[] indegrees = new int[numCourses];
//            List<List<Integer>> adjacency = new ArrayList<>();
//            for (int i = 0; i < numCourses; i++) {
//                adjacency.add(new ArrayList<>());
//            }
//            for (int[] pq : prerequisites) {
//                indegrees[pq[0]]++;
//                adjacency.get(pq[1]).add(pq[0]);
//            }
//            //2. 将所有入度为0的节点（有效起点），加入到一个队列中
//            Queue<Integer> queue = new LinkedList<>();
//            for (int i = 0; i < numCourses; i++) {
//                if (indegrees[i] == 0) {
//                    queue.offer(i);
//                }
//            }
//
//            //3. BFS 判断出队次数是否与课程数量相等（是否可以将所有的节点遍历到）
//            while(!queue.isEmpty()){
//                int pre = queue.poll();
//                numCourses--;
//                for(int cur : adjacency.get(pre)){
//                    indegrees[cur]--;
//                    if(indegrees[cur] == 0) queue.offer(cur);
//                }
//            }
//
//            return numCourses == 0;
            // 法2：DFS
            //1. 建立邻接矩阵与访问标志表
            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }
            for (int[] pq : prerequisites) {
                adjacency.get(pq[1]).add(pq[0]);
            }
            //0:未访问  //-1：其他轮的dfs中被访问过了已访问 //1：当前轮正在访问
            int[] flag = new int[numCourses];
            //2. 对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环
            for (int i = 0; i < numCourses; i++) {
                if(!dfs(adjacency, flag, i)) return false;
            }
            return true;
        }

        public boolean dfs(List<List<Integer>> adjacency, int[] flags, int i){
            if(flags[i] == 1) return false;
            if(flags[i] == -1) return true;
            flags[i] = 1;
            for (int cur : adjacency.get(i)){
                if(!dfs(adjacency, flags, cur)) return false;
            }
            flags[i] = -1;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}