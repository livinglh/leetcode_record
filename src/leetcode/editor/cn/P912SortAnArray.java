//给定一个整数数组 nums，将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：[5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：[5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -50000 <= A[i] <= 50000 
// 
//

  
package leetcode.editor.cn;
//java:排序数组
public class P912SortAnArray{
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    private void mergeSort(int[] nums, int left, int right) {  // 需要左右边界确定排序范围
        if (left >= right) return;
        int mid = (left+right) / 2;

        mergeSort(nums, left, mid);                           // 先对左右子数组进行排序
        mergeSort(nums, mid+1, right);

        int[] temp = new int[right-left+1];                   // 临时数组存放合并结果
        int i=left,j=mid+1;
        int cur = 0;
        while (i<=mid&&j<=right) {                            // 开始合并数组
            if (nums[i]<=nums[j]) temp[cur] = nums[i++];
            else temp[cur] = nums[j++];
            cur++;
        }
        while (i<=mid) temp[cur++] = nums[i++];
        while (j<=right) temp[cur++] = nums[j++];

        for (int k = 0; k < temp.length; k++) {             // 合并数组完成，拷贝到原来的数组中
            nums[left+k] = temp[k];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}