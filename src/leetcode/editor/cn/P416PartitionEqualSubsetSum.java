//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:分割等和子集
public class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

    // 1. 递归 备忘录
//    public boolean canPartition(int[] nums) {
//        boolean visited[] = new boolean[nums.length];
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if ((sum & 1) == 1){
//            return false;
//        }
//        sum >>= 1;
//        Map<Integer,Boolean> map = new HashMap<>();
//        return help(nums, visited, 0, sum, map);
//    }
//
//    public boolean help(int[] nums, boolean[] visited, int cur, int sum, Map<Integer,Boolean> map){
//        if(cur > sum) return false;
//        if(cur == sum){
//            map.put(cur, true);
//            return true;
//        }
//        if(map.containsKey(cur)) return map.get(cur);
//        for (int i = 0; i < nums.length; i++) {
//            if(visited[i] == false){
//                visited[i] = true;
//                if(help(nums, visited, cur + nums[i], sum, map)){
//                    return true;
//                }
//                visited[i] = false;
//            }
//        }
//        map.put(cur, false);
//        return false;
//    }

        //2. 动态规划
        public boolean canPartition(int[] nums) {
            //转化为经典的01背包问题
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 == 1)
                return false;
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            //建立dp数组，dp[i]表示能否找到和为i的数组元素集合
            for (int num : nums) {
                for (int i = target; i >= num; i--) { //一个数字只能用一次
                    if (dp[i - num] == true)
                        dp[i] = true;
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}