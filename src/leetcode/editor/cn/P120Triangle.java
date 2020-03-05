//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

  
package leetcode.editor.cn;

import java.util.List;

//java:三角形最小路径和
public class P120Triangle{
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //法1：自顶向下
//        状态：dp[i][j]包含第i行第j列元素的最小路径和
//        初始化：dp[0][0]=triangle[0][0]
//        一般：triangle[i][j]一定会经过triangle[i-1][j]或者triangle[i-1][j-1],
//                所以状态dp[i][j]一定等于dp[i-1][j]或者dp[i-1][j-1]的最小值+triangle[i][j]
//        特殊：
//            triangle[i][0]没有左上角 只能从triangle[i-1][j]经过
//            triangle[i][row[0].length]没有上面 只能从triangle[i-1][j-1]经过
//        转换方程：dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]
//        if(triangle == null || triangle.size() == 0) return 0;
//        //初始化dp数组
//        int rows = triangle.size();
//        int cols = triangle.get(rows-1).size();
//        int[][] dp = new int[rows][cols];
//        dp[0][0] = triangle.get(0).get(0);
//
//        //从第二行开始，计算dp[i][j]
//        for (int i = 1; i < rows; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                if(j == 0) dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
//                else if(j == i) dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
//                else{
//                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
//                }
//            }
//        }
//        //在dp数组的最后一行选择其中最小的
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < cols; i++) {
//            ans = Math.min(ans,dp[rows-1][i]);
//        }
//        return ans;
//        //时间复杂度O(n2) 空间复杂度O(n2)
        //法2 对法1的空间复杂度进行优化 对dp第i行最小路径的推导，只需要第i-1行的两个元素dp[i-1][j-1],dp[i-1][j]
        //leftup : dp[i-1][j-1],  up : dp[i-1][j]
//        if(triangle == null || triangle.size() == 0) return 0;
//        //初始化dp数组
//        int rows = triangle.size();
//        int cols = triangle.get(rows-1).size();
//        int[] dp = new int[cols];
//        dp[0] = triangle.get(0).get(0);
//        int leftup = 0, up;
//        //从第二行开始，计算dp[i][j]
//        for (int i = 1; i < rows; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                up = dp[j];
//                if(j == 0) dp[j] = up + triangle.get(i).get(j);
//                else if(j == i) dp[j] = leftup + triangle.get(i).get(j);
//                else{
//                    dp[j] = Math.min(up,leftup) + triangle.get(i).get(j);
//                }
//                leftup = up;
//            }
//        }
//        //在dp数组的最后一行选择其中最小的
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < cols; i++) {
//            ans = Math.min(ans,dp[i]);
//        }
//        return ans;
//        //时间复杂度O(n2) 空间复杂度O(n)
        //法3 自底向上
//        状态：dp[i][j]包含第i行第j列元素的最小路径和
//        初始化：dp最后一行等于triangle最后一行
//        一般：
//                所以状态dp[i][j]一定等于dp[i+1][j]或者dp[i+1][j+1]的最小值+triangle[i][j]
//        转换方程：dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
        if(triangle == null || triangle.size() == 0) return 0;
        //初始化dp数组
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();
        int[] dp = new int[cols];
        for (int j = 0; j < cols ; j++) {
            dp[j] = triangle.get(rows-1).get(j);
        }
        for (int i = rows-2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}