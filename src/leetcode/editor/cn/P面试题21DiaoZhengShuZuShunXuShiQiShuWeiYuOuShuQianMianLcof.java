//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
//

  
package leetcode.editor.cn;
//java:调整数组顺序使奇数位于偶数前面
public class P面试题21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        int[] list = {8,10,3,20,12,4,10,8,4,0,5,17,7,20,3};
        Solution solution = new P面试题21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        solution.exchange(list);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i < j){
            if(nums[i] % 2 == 0){
                // 从末尾向前找到第一个奇数
                while(nums[j] % 2 == 0 && j > i){
                    j--;
                }
                // 若均为偶数，直接返回
                if(i == 0 && j == 0) return nums;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
            i ++;
        }
        return nums;
    }
}

//    class Solution {
//        public int[] exchange(int[] nums) {
//            int left = 0;
//            int right = nums.length - 1;
//            while (left < right) {
//                while (left < right && nums[left] % 2 != 0) {
//                    left++;
//                }
//                while (left < right && nums[right] % 2 == 0) {
//                    right--;
//                }
//                if (left < right) {
//                    int temp = nums[left];
//                    nums[left] = nums[right];
//                    nums[right] = temp;
//                }
//            }
//            return nums;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}