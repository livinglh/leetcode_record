//给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从 节点 0 出发，请你返回最
//少需要多少秒，可以收集到所有苹果，并回到节点 0 。 
//
// 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数
//组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,fa
//lse,true,false,true,true,false]
//输出：8 
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,fa
//lse,true,false,false,true,false]
//输出：6
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 3： 
//
// 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,fa
//lse,false,false,false,false,false]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// edges.length == n-1 
// edges[i].length == 2 
// 0 <= fromi, toi <= n-1 
// fromi < toi 
// hasApple.length == n 
// 
// Related Topics 树 深度优先搜索

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:收集树上所有苹果的最少时间
public class P1443MinimumTimeToCollectAllApplesInATree{
    public static void main(String[] args) {
        Solution solution = new P1443MinimumTimeToCollectAllApplesInATree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer,List<Integer>> eMap=new HashMap<>();
        public boolean dfs(int cur, List<Boolean> hasApple){
            boolean has = hasApple.get(cur);
            for(int next: eMap.get(cur)){
                if(dfs(next,hasApple)){
                    has = true;
                }
            }
            hasApple.set(cur,has);
            return has;
        }

        public int cmp(int cur, List<Boolean> hasApple){
            int res = 0;
            for(int next: eMap.get(cur)){
                if(hasApple.get(next)){
                    res += 2 + cmp(next, hasApple);
                }
            }
            return res;
        }

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            //建树
            for(int i = 0; i< n; i++){
                eMap.put(i, new ArrayList<>());
            }
            for(int[] edge:edges){
                eMap.get(edge[0]).add(edge[1]);
            }
            //标记
            dfs(0, hasApple);
            //计算
            return cmp(0, hasApple);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}