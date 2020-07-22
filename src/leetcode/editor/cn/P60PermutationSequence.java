//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 277 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:第k个排列
public class P60PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new P60PermutationSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String ans = null;
        int cur = 0;
        public String getPermutation(int n, int k) {
            boolean[] visited = new boolean[n + 1];
            List<Integer> path = new ArrayList<>();
            back(path, n, visited, k);
            return ans;
        }

        public void back(List<Integer> path, int n, boolean[] visited, int k) {
            if(ans!=null) return;
            if (path.size() == n) {
                cur++;
                if(cur == k) {
                    //ans = String.valueOf(path.stream().mapToInt(Integer::intValue).toArray());
                    StringBuilder sb = new StringBuilder();
                    for(Integer each : path) {
                        sb.append(each);
                    }
                    ans = sb.toString();
                }
            }
            for (int i = 1; i <= n; i++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    path.add(i);
                    back(path, n, visited, k);
                    visited[i] = false;
                    path.remove(path.size() - 1);
                }
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}