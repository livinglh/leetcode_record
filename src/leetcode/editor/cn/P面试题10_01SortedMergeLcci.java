//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

  
package leetcode.editor.cn;
//java:合并排序的数组
public class P面试题10_01SortedMergeLcci{
    public static void main(String[] args) {
        Solution solution = new P面试题10_01SortedMergeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        //1. 从前向后填充
//        int i = 0, j = 0;
//        while(i < m && j < n){
//            if(A[i]<=B[j]){
//                i++;
//            }
//            else{
//                move(A,i,m);
//                A[i] = B[j];
//                j++;
//                m++;
//            }
//        }
//        if (j!= n){
//            for (int k = j; k < n; k++) {
//                A[i++] = B[k];
//            }
//        }
//    }
//    // 将A数组，下标为i后的数据后移一位
//    public void move(int[] A, int i, int m){
//        for (int j = m; j > i ; j--) {
//            A[j] = A[j-1];
//        }
//    }
    //2. 从后向前填充（省去了每次要移动A数组的时间）
        while(m > 0 && n > 0){
            if(A[m-1] <= B[n-1]){
                A[m+n-1] = B[n-1];
                n--;
            }else{
                A[m+n-1] = A[m-1];
                m--;
            }
        }
        while(n>0){
            A[n-1] = B[n-1];
            n--;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}