//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
//

  
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//java:和为s的两个数字
public class P面试题57HeWeiSdeLiangGeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题57HeWeiSdeLiangGeShuZiLcof().new Solution();
        int[] nums = {16,16,18,24,30,32};
        solution.twoSum(nums, 48);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
//        //暴力： 超时
//        if(nums[0] > target) return new int[2];
//        int[] ans = new int[2];
//        int sum;
//        for (int i = 0; i < nums.length ; i++) {
//            for (int j = i + 1; j < nums.length ; j++) {
//                if(nums[j] > target) continue;
//                sum = nums[i] + nums[j];
//                if(sum == target){
//                    ans[0] = nums[i];
//                    ans[1] = nums[j];
//                    return ans;
//                }
//            }
//        }
//
//        return ans;
//        // 字典法
//        int[] ans = new int[2];
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if(set.contains(target - num)){
//                ans[0] = target -num;
//                ans[1] = num;
//                return ans;
//            }else{
//                set.add(num);
//            }
//        }
//        return ans;
        //双指针
        int left = 0, right = nums.length-1;
        int[] ans = new int[2];
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                ans[0] = nums[left];
                ans[1] = nums[right];
                return ans;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}