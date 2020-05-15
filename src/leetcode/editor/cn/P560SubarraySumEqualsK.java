//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:和为K的子数组
public class P560SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        //1. 暴力解法
//        if(nums == null || nums.length == 0) return 0;
//        int len = nums.length;
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            int sum = 0;
//            for (int j = i; j < len; j++) {
//                sum += nums[j];
//                if(sum == k){
//                    res += 1;
//                }
//            }
//        }
//        return res;
        //2. 前缀和 On2
//        if(nums == null || nums.length == 0) return 0;
//        int len = nums.length,res = 0;
//        int[] preSum = new int[len+1];
//        for (int i = 0; i < len; i++) {
//            if(i == 0) preSum[i] = nums[0];
//            preSum[i+1] = preSum[i] + nums[i];
//        }
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if(preSum[j+1] - preSum[i] == k) {
//                    res += 1;
//                }
//            }
//        }
//        return res;
        //3. 前缀和+哈希表 On
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length, sum = 0, res = 0;
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);

        for(int num : nums){
            sum += num;
            // 获得前缀和为 preSum - k 的个数，加到计数变量里
            if(preSum.containsKey(sum-k)){
                res += preSum.get(sum-k);
            }
            preSum.put(sum, preSum.getOrDefault(sum,0)+1);
        }

        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}