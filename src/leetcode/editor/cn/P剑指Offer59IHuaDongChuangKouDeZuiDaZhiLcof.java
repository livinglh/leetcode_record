//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 364 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

import com.sun.jdi.connect.spi.TransportService.ListenKey;

// java: 滑动窗口的最大值
public class P剑指Offer59IHuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer59IHuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            //        // 迭代
            //        if (nums.length == 0){
            //            return new int[0];
            //        }
            //        int[] res = new int[nums.length - k + 1];
            //        int max = Integer.MIN_VALUE;
            //        int index = -1;
            //        for (int i = 0; i < nums.length - k + 1; i++) {
            //            if (index >= i && index < i + k) {
            //                if (nums[i + k - 1] > max) {
            //                    index = i + k - 1;
            //                    max = nums[i + k - 1];
            //                }
            //            } else {
            //                max = nums[i];
            //                for (int j = i + 1; j < i + k; j++) {
            //                    if (nums[j] > max) {
            //                        max = nums[j];
            //                        index = j;
            //                    }
            //                }
            //            }
            //            res[i] = max;
            //        }
            //        return res;
            if (nums.length == 0 || k == 0) {
                return new int[0];
            }
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(nums[i]);
            }
            res[0] = deque.peekFirst();
            for (int i = k; i < nums.length; i++) {
                if (deque.peekFirst() == nums[i - k]) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(nums[i]);
                res[i - k + 1] = deque.peekFirst();
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}