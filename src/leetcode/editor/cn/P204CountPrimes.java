//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学 
// 👍 418 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

//java:计数质数
public class P204CountPrimes{
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i < n; i++) {
            if(isPrim[i]){
                // 如果这个数是质数，那么这个数的倍数一定不是质数
                for (int j = 2 * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrim[i]){
                count ++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}