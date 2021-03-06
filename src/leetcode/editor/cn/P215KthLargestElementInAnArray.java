//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

//java:数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //    public int findKthLargest(int[] nums, int k) {
//        // 1. 最小堆 Onlogn
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for(int n : nums){
//            heap.offer(n);
//            if(heap.size() > k){
//                heap.poll();
//            }
//        }
//        return heap.peek();
//    }
        // 2. 快排 O(n)
        private Random random = new Random(System.currentTimeMillis());

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int target = len - k;
            int left = 0;
            int right = len - 1;
            while (true) {
                int index = partition(nums, left, right);
                if (index < target) {
                    left = index + 1;
                } else if (index > target) {
                    right = index - 1;
                } else {
                    return nums[index];
                }
            }
        }

        // 在区间 [left, right] 这个区间执行 partition 操作

        private int partition(int[] nums, int left, int right) {
            // 在区间随机选择一个元素作为标定点
            if (right > left) {
                int randomIndex = left + 1 + random.nextInt(right - left);
                swap(nums, left, randomIndex);
            }

            int pivot = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    j++;
                    swap(nums, j, i);
                }
            }
            swap(nums, left, j);
            return j;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}