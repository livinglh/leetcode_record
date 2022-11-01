//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 619 👎 0


package leetcode.editor.cn;

//java:数组中的逆序对
public class P剑指Offer51ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer51ShuZuZhongDeNiXuDuiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;

        public int reversePairs(int[] nums) {
            mergeSort(nums, 0, nums.length-1);
            return ans;
        }

        public void mergeSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int mid = left + ((right - left) >>> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            int[] temp = new int[right - left + 1];
            int i = left, j = mid + 1;
            int index = 0;
            while(i <= mid && j <= right) {
                if(nums[i] > nums[j]) {
                    ans = ans + mid - i + 1;
                    temp[index++] = nums[j++];
                } else {
                    temp[index++] = nums[i++];
                }
            }

            while(i <= mid) {
                temp[index++] = nums[i++];
            }

            while(j <= right) {
                temp[index++] = nums[j++];
            }

            for (int k = 0; k < temp.length; k++) {
                nums[left+k] = temp[k];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}