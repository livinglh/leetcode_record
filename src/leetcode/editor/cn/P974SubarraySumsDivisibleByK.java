//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:和可被 K 整除的子数组
public class P974SubarraySumsDivisibleByK{
    public static void main(String[] args) {
        Solution solution = new P974SubarraySumsDivisibleByK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        //1. 超时
//        int[] dp = new int[A.length+1];  //dp[i] 表示前i个数之和
//        dp[0] = 0;
//        int res = 0;
//        for (int j = 1; j < dp.length; j++) {
//            dp[j] = dp[j-1] + A[j-1];
//            for (int i = 0; i < j; i++) {
////                System.out.println(j+"---"+i+"---"+dp[j]+"---"+dp[i]);
//                if((dp[j] - dp[i])%K == 0){
//                    res +=1;
//                }
//            }
//        }
//        return res;
        //2. 哈希表
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1); //考虑前缀和本身被 K 整除的情况
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;

//        Map<Integer, Integer> record = new HashMap<>();
//        record.put(0, 1);
//        int sum = 0;
//        for (int elem: A) {
//            sum += elem;
//            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
//            int modulus = (sum % K + K) % K;
//            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
//        }
//
//        int ans = 0;
//        for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
//            ans += entry.getValue() * (entry.getValue() - 1) / 2;
//        }
//        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}