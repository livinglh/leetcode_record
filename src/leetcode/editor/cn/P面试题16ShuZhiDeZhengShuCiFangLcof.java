//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归

  
package leetcode.editor.cn;
//java:数值的整数次方
public class P面试题16ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题16ShuZhiDeZhengShuCiFangLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public double myPow(double x, int n) {
//        //快速幂
////        if(x == 0) return 0;
////        long b = n;
////        double res = 1.0;
////        if(b<0){
////            x = 1 / x;
////            b = 0 - b;
////        }
////        while(b>0){
////            if((b & 1) == 1) res *= x;
////            x *= x;
////            b >>= 1;
////        }
////        return res;
//        // 迭代
//        double ans = 1, temp = x;
//        int exp = n;
//        while (exp != 0) {
//            if ((exp % 2) != 0) {
//                ans = ans * temp;
//            }
//            temp = temp * temp;
//            exp /= 2;
//        }
//        return n > 0 ? ans : 1 / ans;
//    }
//}
// 二分快速幂
    public class Solution {

        public double myPow(double x, int n) {
            // 特判，也可以认为是递归终止条件
            long N = n;
            if (N < 0) {
                return 1 / myPow(x, -N);
            }
            return myPow(x, N);
        }

        private double myPow(double x, long n) {
            if (n == 0) {
                return 1;
            }

            if (x == 1) {
                return 1;
            }

            // 根据指数是奇数还是偶数进行分类讨论
            // 使用位运算的 与 运算符代替了求余数运算

            if ((n & 1) == 0) {
                // 分治思想：分
                double square = myPow(x, n >>> 1);
                // 分治思想：合，下面同理
                return square * square;
            } else {
                // 是奇数的时候
                double square = myPow(x, (n - 1) >>> 1);
                return square * square * x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}