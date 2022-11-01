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
// Related Topics 位运算 数组 👍 265 👎 0


package leetcode.editor.cn;

// java: 数组中数字出现的次数 II
public class P剑指Offer56IIShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer56IIShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] counts = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    counts[i] += num & 1;
                    num >>>= 1;
                }
            }
            int res = 0, m = 3;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res |= counts[31 - i] % m;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}