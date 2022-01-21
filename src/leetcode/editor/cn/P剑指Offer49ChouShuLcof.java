//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 259 👎 0


package leetcode.editor.cn;

// java: 丑数
public class P剑指Offer49ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer49ChouShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1; // 丑数序列
            int index2 = 0, index3 = 0, index5 = 0; //三个指针
            for (int i = 1; i < n; i++) {
                // 三个中选择较小的
                int factor2 = 2 * ugly[index2];
                int factor3 = 3 * ugly[index3];
                int factor5 = 5 * ugly[index5];
                int min = Math.min(Math.min(factor2, factor3), factor5);
                ugly[i] = min;//更新丑数序列
                if (factor2 == min) {
                    index2++;
                }
                if (factor3 == min) {
                    index3++;
                }
                if (factor5 == min) {
                    index5++;
                }
            }
            return ugly[n - 1];
            // 使用treeset
            //        TreeSet<Long> set = new TreeSet<Long>();
            //        int count = 0;
            //        long result = 1;
            //        set.add(result);
            //        while (count < n) {
            //            result = set.pollFirst();
            //            count++;
            //            set.add(result * 2);
            //            set.add(result * 3);
            //            set.add(result * 5);
            //        }
            //        return (int) result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}