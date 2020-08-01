//公司共有 n 个项目和 m 个小组，每个项目要不没有归属，要不就由其中的一个小组负责。 
//
// 我们用 group[i] 代表第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的） 
//
//
// 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表： 
//
// 
// 同一小组的项目，排序后在列表中彼此相邻。 
// 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个
//项目左侧）应该完成的所有项目。 
// 
//
// 结果要求： 
//
// 如果存在多个解决方案，只需要返回其中任意一个即可。 
//
// 如果没有合适的解决方案，就请返回一个 空列表。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],
//[3,6],[],[],[]]
//输出：[6,3,4,1,5,2,0,7]
// 
//
// 示例 2： 
//
// 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],
//[3],[],[4],[]]
//输出：[]
//解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m <= n <= 3*10^4 
// group.length == beforeItems.length == n 
// -1 <= group[i] <= m-1 
// 0 <= beforeItems[i].length <= n-1 
// 0 <= beforeItems[i][j] <= n-1 
// i != beforeItems[i][j] 
// 
// Related Topics 深度优先搜索 图 拓扑排序 
// 👍 32 👎 0

  
package leetcode.editor.cn;

import java.util.*;

//java:项目管理
public class P1203SortItemsByGroupsRespectingDependencies{
    public static void main(String[] args) {
        Solution solution = new P1203SortItemsByGroupsRespectingDependencies().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 组依赖图及访问标识（1正在访问，0未访问，-1已访问且无环）
        private Node[] grpGraph;
        private int[] grpVisited;
        // 项目依赖图及访问标识
        private Node[] prdGraph;
        private int[] prdVisited;

        // 项目与组映射关系
        private int[] prdToGrp;
        // 组与项目映射关系
        private Map<Integer, Set<Integer>> grpToPrd;
        // 节省时间
        int[] res;
        int idx = 0;

        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            if (m < 1 || n < 1 || n < m || n != group.length || n != beforeItems.size()) throw new IllegalArgumentException("invalid param");

            prdToGrp = group;
            grpToPrd = new HashMap<>();
            // 构建项目依赖图和组依赖图
            grpGraph = new Node[m + 1]; // 多一个存放-1，无组情况
            prdGraph = new Node[n];
            grpVisited = new int[m + 1];
            prdVisited = new int[n];

            // 遍历每个项目
            for (int i = 0; i < n; i++) {
                // 当前项目的组，如果没有组则分配组的下标为m
                int curGrp = group[i] == -1 ? m : group[i];
                if (grpToPrd.get(curGrp) == null) grpToPrd.put(curGrp, new HashSet<>());
                grpToPrd.get(curGrp).add(i);

                // 当前项目依赖的项目
                for (Integer item : beforeItems.get(i)) {
                    prdGraph[i] = new Node(item, prdGraph[i]);

                    int itemGrp = group[item] == -1 ? m : group[item];
                    // 维护组依赖，杜绝自环情况
                    if (curGrp != itemGrp) {
                        // 存在重复边，不影响拓扑排序
                        grpGraph[curGrp] = new Node(itemGrp, grpGraph[curGrp]);
                    }
                }
            }

            // 根据组依赖拓扑排序，深度搜索
            res = new int[n];
            for (int i = 0; i <= m; i++) {
                // 存在环，返回空数组
                if (grpVisited[i] == 0 && !dfsParent(i)) {
                    return new int[]{};
                }
            }

            return res;
        }

        private boolean dfsParent(int start) {
            // 正在遍历或已经遍历过，返回（1为有环，-1则不必遍历）
            if (grpVisited[start] != 0) return grpVisited[start] == -1;
            // 标记为正在遍历
            grpVisited[start] = 1;
            // 拓扑排序当前组
            Node temp = grpGraph[start];
            while (temp != null) {
                // 后继存在环，则返回失败
                if(!dfsParent(temp.ver)) return false;
                temp = temp.next;
            }
            Set<Integer> childVers = grpToPrd.getOrDefault(start, new HashSet<>());
            for (Integer cur : childVers) {
                // 组内项目循环依赖
                if (prdVisited[cur] == 0 && !dfsChild(cur)) return false;
            }
            // 遍历结束，设置标识
            grpVisited[start] = -1;
            return true;
        }

        private boolean dfsChild(int start) {
            // 组内存在环则是1，已遍历则是-1
            if (prdVisited[start] != 0) return prdVisited[start] == -1;

            // 标记为正在访问
            prdVisited[start] = 1;
            Node temp = prdGraph[start];
            while (temp != null) {
                // 遍历与start同一分组的后继结点，如果后续路径不满足条件存在环，返回
                if (prdToGrp[start] == prdToGrp[temp.ver] && !dfsChild(temp.ver)) {
                    return false;
                }
                temp = temp.next;
            }
            // 子路径已遍历完
            res[idx++] = start;
            prdVisited[start] = -1;
            return true;
        }
    }

    class Node {
        int ver;
        Node next;

        Node(int ver, Node next) {
            this.ver = ver;
            this.next = next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}