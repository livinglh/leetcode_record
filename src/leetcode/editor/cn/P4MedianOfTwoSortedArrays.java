//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

  
package leetcode.editor.cn;
//java:寻找两个有序数组的中位数
public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        int[] a = new int[]{};
        int[] b = new int[]{3,4};
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(a, b));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //法1 寻找中间的两个数（一个数）
//        int pre = 0,cur = 0;
//        int index1 = 0, index2 = 0;
//        int len = nums1.length + nums2.length;
//        for(int i = 0; i <= len / 2; i++){
//            pre = cur;
//            if(index1 < nums1.length && (index2 >= nums2.length || nums1[index1] < nums2[index2]))
//                cur = nums1[index1++];
//            else
//                cur = nums2[index2++];
//        }
//        return len % 2 == 0 ? (pre+cur)/2.0 : cur;
        //法2 二分法 寻找合适的分割点
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int imin = 0, imax = m;
        while(imin <= imax){
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < imax && nums2[j-1] > nums1[i])
                imin = i + 1;
            else if (i > imin && nums1[i-1] > nums2[j])
                imax = i - 1;
            else{  //找到切割点
                int maxleft;
                if(i == 0) maxleft = nums2[j-1];
                else if(j == 0) maxleft = nums1[i-1];
                else maxleft = Math.max(nums1[i-1], nums2[j-1]);
                if((m + n) % 2 == 1) return maxleft;
                int minright;
                if(i == m) minright = nums2[j];
                else if(j == n) minright = nums1[i];
                else minright = Math.min(nums1[i], nums2[j]);
                return (minright + maxleft) / 2.0;
            }
        }
        return 0.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}