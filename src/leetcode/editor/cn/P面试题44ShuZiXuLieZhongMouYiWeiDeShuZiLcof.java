//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学

  
package leetcode.editor.cn;
//java:数字序列中某一位的数字
public class P面试题44ShuZiXuLieZhongMouYiWeiDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题44ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        solution.findNthDigit(1000000000);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution { // 1000000000出错
//    public int findNthDigit(int n) {
//        int base = 9, grow = 1;
//        int sum = 10; // 0-9 占10位
//        while(sum < n+1){
//            base *= 10;
//            grow += 1;
//            sum += base * grow;
//        }
//        if(n<10){
//            return n;
//        }
//        else {
//            sum -= base * grow;
//            int res = n + 1 - sum;
//            int num = (int)Math.pow(10, grow-1) + (int)res / grow;
//            if(res % grow == 0){
//                num--;
//                return num % 10;
//            }
//            else{
//                int index = (res % grow) - 1;
//                return (int)String.valueOf(num).charAt(index) - (int)('0');
//            }
//        }
//    }
//}
    class Solution {
        public int findNthDigit(int n) {
            // 判断是否个位数
            if (n < 10) {
                return n;
            }

            // 第一步：计算减去个位数后的剩余值： n = n - 9 * 10^0 - 9 * 10^1 - 9 * 10^(n - 1)
            int base = 1;
            long count = 0;  //计算有多少位,测试的时候发现有个1e9的用例，这个用例会导致count越界
            while (true) {
                count = base == 1 ? 10 : (long) (Math.pow(10, base - 1) * 9 * base);
                if (n < count) break;
                n -= count;
                base++;
            }

            // 第二步：num = n / base + Math.pow(10, base - 1)，然后在进行求余 num % base找到对应num的地方，
            int num = (int) (n / base + Math.pow(10, base - 1));
            return String.valueOf(num).charAt(n % base) - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}