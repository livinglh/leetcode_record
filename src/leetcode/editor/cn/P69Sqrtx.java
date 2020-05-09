//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

  
package leetcode.editor.cn;
//java:x 的平方根
public class P69Sqrtx{
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        // 1. 数学公式
//        if(x == 0) return 0;
//        int ans = (int) Math.exp(0.5 * Math.log(x));  //浮点数运算存在误差
//        return (long)(ans+1)*(ans+1) <= x ? ans + 1 : ans;
        // 2. 二分法
//        if(x == 0 || x == 1) return x;
//        int left =  0, right = x/2;
//        while(left <= right){
//            int mid = left + (right - left) / 2 ;
//            if((long)mid * mid <= x){
//                left = mid + 1;
//            }else{
//                right = mid - 1;
//            }
//        }
//        return right;
        // 3. 牛顿迭代法
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}