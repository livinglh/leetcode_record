//给你一个整数数组 nums 和一个整数 k。 
//
// 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。 
//
// 请返回这个数组中「优美子数组」的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
// 
//
// 示例 3： 
//
// 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 双指针

  
package leetcode.editor.cn;

import java.util.HashMap;

//java:统计「优美子数组」
public class P1248CountNumberOfNiceSubarrays{
    public static void main(String[] args) {
        Solution solution = new P1248CountNumberOfNiceSubarrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            // 双指针
//            if (nums == null || nums.length < k) return 0;
//            int left = 0, right = 0;
//            int count = 0; // 连续子数组中奇数的个数
//            int res = 0;
//            int preEven = 0; // 记录第一个奇数前面的偶数个数
//            while (right < nums.length){
//                // 连续子数组中奇数个数不够
//                if (count < k){
//                    if (nums[right] % 2 != 0) count++;
//                    right++; // 移动右侧指针
//                }
//                // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
//                if (count == k) {
//                    preEven = 0;
//                    while (count == k){
//                        res++;
//                        if (nums[left] % 2 != 0) count--;
//                        left++;
//                        preEven++;
//                    }
//                } else res += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
//            }
//            return res;

            // 前缀和
            // sum是前缀和
            int sum=0;
            int res=0;
            // map的键是前缀和  map的值是前缀和出现的次数
            HashMap<Integer,Integer> map=new HashMap<>();
            // 前缀和为0 出现的次数是1次
            map.put(0,1);
            for(int num:nums){
                sum+=(num&1);
                /*当前前缀和是sum，尝试在map中查找 是否存在键值是sum-k(即前缀和是sum-k) ，若找到，即找到子序列和是k*/
                if(map.containsKey(sum-k)){
                    res+=map.get(sum-k);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}