//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和 排序 双指针

public class P15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length-2; i++) {
                if(i==0 || (i>0 && nums[i] != nums[i-1])){
                   int left = i+1,right = nums.length-1,sum = 0 - nums[i];
                   while(left<right){
                       if(nums[left] + nums[right] == sum){
                           ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                           while(left<right && nums[left] == nums[left + 1]) left++;
                           while(left<right && nums[right] == nums[right - 1]) right--;
                           left ++;
                           right--;
                       } else if(nums[left] + nums[right] < sum){
                           while(left<right && nums[left] == nums[left + 1]) left++;
                           left ++;
                       } else {
                           while(left<right && nums[right] == nums[right - 1]) right--;
                           right--;
                       }

                   }
                }
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}