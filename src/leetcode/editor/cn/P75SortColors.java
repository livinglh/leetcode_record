//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针

  
package leetcode.editor.cn;
//java:颜色分类
public class P75SortColors{
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        //1. 此问题为荷兰国旗问题
        //设置三个指针（p0，p2，cur）分别追踪0的最右边界，2的最左边界和当前位置
        int p0 = 0, p2 = nums.length-1, cur = 0;
        int temp = -1;
        while(cur <= p2){
            if(nums[cur] == 0){
                temp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = temp;
            }else if(nums[cur] == 1){
                cur ++;
            }else if(nums[cur] == 2){
                temp = nums[p2];
                nums[p2--] = nums[cur];
                nums[cur] = temp;
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}