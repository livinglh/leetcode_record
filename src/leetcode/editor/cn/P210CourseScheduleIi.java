//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 
//
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

  
package leetcode.editor.cn;

import java.text.DateFormatSymbols;
import java.util.*;

//java:课程表 II
public class P210CourseScheduleIi{
    public static void main(String[] args) {
        Solution solution = new P210CourseScheduleIi().new Solution();
        solution.findOrder(2,new int[][]{{1,0}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 1. DFS
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        if (numCourses == 0) return new int[]{};
//        HashSet<Integer>[] graphSet = new HashSet[numCourses]; //先修-后修课程
//        for (int i = 0; i < numCourses; i++) {
//            graphSet[i] = new HashSet<>();
//        }
//        for (int[] p : prerequisites) {
//            graphSet[p[1]].add(p[0]);
//        }
//        int[] status = new int[numCourses];
//        Stack<Integer> stack = new Stack<>();
//        // DFS 存在环就返回
//        for (int i = 0; i < numCourses; i++) {
//            if(DFS(i , status, graphSet, stack)) {
//                return new int[]{};
//            }
//        }
//        int[] res = new int[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            res[i] = stack.pop();
//        }
//        return res;
//    }
//
//    // 查看是否有环 有返回true
//    private boolean DFS(int src, int[] status, HashSet<Integer>[] graphSet, Stack<Integer> stack){
//        if(status[src] == -1) {
//            return false;
//        }
//        if(status[src] == 1) {
//            return true;
//        }
//
//        status[src] = 1;
//        for (int neighbor: graphSet[src]) {
//            System.out.println(neighbor);
//            if(DFS(neighbor, status, graphSet, stack)) {
//                return true;
//            }
//        }
//
//        status[src] = -1;
//        stack.push(src);
//
//        return false;
//    }
    //2. BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr;   // 将可以学完的课程加入结果当中
            // 将 u 的所有相邻节点的入度减少 1。如果某个相邻节点 v 的入度变为 0，那么我们就将 v 放入队列中。
            for (int[] p : prerequisites) {
                if (p[1] == curr){
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}