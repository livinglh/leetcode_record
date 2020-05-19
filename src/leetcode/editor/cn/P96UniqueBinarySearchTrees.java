//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

  
package leetcode.editor.cn;
//java:不同的二叉搜索树
public class P96UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //1. 记忆化递归 备忘录
//        public int numTrees(int n) {
//            return helper(1,n,new int[n+1][n+1]);
//        }
//
//        public int helper(int start,int end,int[][] memo){
//            if (end-start<=0)
//                return 1;
//            if (end-start==1)
//                return 2;
//            if (memo[start][end]!=0)
//                return memo[start][end];
//            int ans=0;
//            for (int i=start;i<=end;++i){
//                ans+=helper(start,i-1,memo)*helper(i+1,end,memo);
//            }
//            memo[start][end]=ans;
//            return ans;
//        }

        //2. 动态规划  G(n) 和序列的内容无关，只和序列的长度有关
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                for (int j = 0; j <= i-1; j++) {
                    dp[i] += dp[j] * dp[i-1-j];
                }
            }
            return dp[n];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}