//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算

  
package leetcode.editor.cn;
//java:汉明距离
public class P461HammingDistance{
    public static void main(String[] args) {
        Solution solution = new P461HammingDistance().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        //1. 内置函数
//        return Integer.bitCount(x ^ y);
        //2. 移位
//        int xor = x ^ y;
//        int distance = 0;
//        while (xor != 0) {
//            if (xor % 2 == 1)
//                distance += 1;
//            xor = xor >> 1;
//        }
//        return distance;
        //3. 当我们在 number 和 number-1 上做 AND 位运算时，原数字 number 的最右边等于 1 的比特会被移除
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}