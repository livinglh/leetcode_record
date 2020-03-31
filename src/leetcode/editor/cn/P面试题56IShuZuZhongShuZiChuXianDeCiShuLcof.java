//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums <= 10000 
// 
//
// 
//

  
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//java:数组中数字出现的次数
public class P面试题56IShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题56IShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 位运算 时间O(n) 空间O(1)  n&-n求一个二进制数的最低位的1对应的数
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int xorNumber = nums[0];
            for(int k=1; k<nums.length; k++){
                xorNumber ^=nums[k];
            }
            int onePosition = xorNumber&(-xorNumber);
            int ans1 = 0, ans2 = 0;
            for(int i=0; i<nums.length; i++){
                if((nums[i]&onePosition)==onePosition){
                    ans1^=nums[i];
                }else{
                    ans2^=nums[i];
                }
            }

            return new int[] {ans1^0, ans2^0};
        }
    }
// 使用HashSet 时间O(n) 空间O(n)
//class Solution {
//    public int[] singleNumbers(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int n : nums) {
//            if (set.contains(n))
//                set.remove(n);
//            else
//                set.add(n);
//        }
//        return set.stream().mapToInt(Integer::intValue).toArray();
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)

}