//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找


package leetcode.editor.cn;

//java:有序矩阵中第K小的元素
public class P378KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            // 二分查找
            int len = matrix.length;
            int left = matrix[0][0];
            int right = matrix[len - 1][len - 1];
            while (left < right) {
                int mid = left + (right - left) / 2;
                int midnum = checkmid(matrix, mid);  // 矩阵中小于等于mid的数量
                if (midnum >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public int checkmid(int[][] matrix, int mid) {
            int res = 0;
            int j = 0, i = matrix.length - 1;
            while(i >= 0 && j < matrix.length){
                if(matrix[i][j] <= mid){
                    j++;
                    res += i+1;
                }else{
                    i--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}