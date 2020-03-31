//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
//

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//java:数组中数字出现的次数 II
public class P面试题56IIShuZuZhongShuZiChuXianDeCiShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题56IIShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 1. hashmap
//    class Solution {
//        public int singleNumber(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return -1;
//            }
//
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (map.containsKey(nums[i])) {
//                    map.put(nums[i], map.get(nums[i]) + 1);
//                } else {
//                    map.put(nums[i], 1);
//                }
//            }
//            for (Integer num : nums) {
//                if (map.get(num) == 1) {
//                    return num;
//                }
//            }
//
//            return -1;
//        }
//    }

    //2. 排序后遍历
//    class Solution {
//        public int singleNumber(int[] nums) {
//            Arrays.sort(nums);
//            int singleNum = 0;
//            if (nums[0] != nums[1]){
//                return nums[0];
//            }
//            if (nums[nums.length-1] != nums[nums.length-2]){
//                return nums[nums.length-1];
//            }
//            for (int i = 1; i < nums.length-1; i++){
//                if (nums[i] != nums[i-1] && nums[i] != nums[i+1]){
//                    singleNum = nums[i];
//                    break;
//                }
//            }
//            return singleNum;
//        }
//    }

    //3. 位运算
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            //int 32位
            for(int i=0;i<32;i++){
                int count =0;
                for(int num:nums){
                    if((num&(1<<i))!=0) count++;
                }
                if(count%3!=0) ans += 1<<i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}