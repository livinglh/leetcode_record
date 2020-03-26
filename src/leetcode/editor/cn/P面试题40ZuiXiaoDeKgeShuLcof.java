//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//java:最小的k个数
public class P面试题40ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题40ZuiXiaoDeKgeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 快排
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 最后一个参数表示我们要找的是下标为k-1的数
            return quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        private int[] quickSearch(int[] nums, int lo, int hi, int k) {
            // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
            int j = partition(nums, lo, hi);
            if (j == k) {
                return Arrays.copyOf(nums, j + 1);
            }
            // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
            return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
        }

        // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];   // 基准值在左边，所以我们要从右边开搜
            int i = lo, j = hi + 1;
            while (true) {
                while (--j >= lo && nums[j] > v);
                while (++i <= hi && nums[i] < v);
                if (i >= j) {
                    break;
                }
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            nums[lo] = nums[j];
            nums[j] = v;
            return j;
        }
    }
    // 二叉搜索树
//    class Solution {
//        public int[] getLeastNumbers(int[] arr, int k) {
//            if (k == 0 || arr.length == 0) {
//                return new int[0];
//            }
//            // TreeMap的key是数字, value是该数字的个数。
//            // cnt表示当前map总共存了多少个数字。
//            TreeMap<Integer, Integer> map = new TreeMap<>();
//            int cnt = 0;
//            for (int num: arr) {
//                // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
//                if (cnt < k) {
//                    map.put(num, map.getOrDefault(num, 0) + 1);
//                    cnt++;
//                    continue;
//                }
//                // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
//                //    若当前数字比map中最大的数字还大，就直接忽略；
//                //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
//                Map.Entry<Integer, Integer> entry = map.lastEntry();
//                if (entry.getKey() > num) {
//                    map.put(num, map.getOrDefault(num, 0) + 1);
//                    if (entry.getValue() == 1) {
//                        map.pollLastEntry();
//                    } else {
//                        map.put(entry.getKey(), entry.getValue() - 1);
//                    }
//                }
//
//            }
//
//            // 最后返回map中的元素
//            int[] res = new int[k];
//            int idx = 0;
//            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//                int freq = entry.getValue();
//                while (freq-- > 0) {
//                    res[idx++] = entry.getKey();
//                }
//            }
//            return res;
//        }
//    }

    // 大根堆
//    class Solution {
//        public int[] getLeastNumbers(int[] arr, int k) {
//            if (k == 0 || arr.length == 0) {
//                return new int[0];
//            }
//            // 默认是小根堆，实现大根堆需要重写一下比较器。
//            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
//            for (int num: arr) {
//                if (pq.size() < k) {
//                    pq.offer(num);
//                } else if (num < pq.peek()) {
//                    pq.poll();
//                    pq.offer(num);
//                }
//            }
//
//            // 返回堆中的元素
//            int[] res = new int[pq.size()];
//            int idx = 0;
//            for(int num: pq) {
//                res[idx++] = num;
//            }
//            return res;
//        }
//    }

//leetcode submit region end(Prohibit modification and deletion)

}