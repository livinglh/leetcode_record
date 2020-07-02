//给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 
//
// 注意：1 ≤ k ≤ n ≤ 109。 
//
// 示例 : 
//
// 
//输入:
//n: 13   k: 2
//
//输出:
//10
//
//解释:
//字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//

  
package leetcode.editor.cn;
//java:字典序的第K小数字
public class P440KThSmallestInLexicographicalOrder{
    public static void main(String[] args) {
        Solution solution = new P440KThSmallestInLexicographicalOrder().new Solution();
        solution.findKthNumber(100, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        int curr = 1;//作为一个指针，指向当前所在位置，当curr==k时，也就是到了排位第k的数
        while (curr < k) {
            int prefixnum = staticnum(n, prefix);
            if (prefixnum + curr > k) {  //第k个数在当前前缀下
                prefix *= 10; //往下层遍历
                curr++;//把指针指向了第一个子节点的位置，比如11乘10后变成110，指针从11指向了110
            } else {//不在当前前缀下
                //注意这里的操作，把指针指向了下一前缀的起点
                prefix++;//换到下一个前缀
                curr += prefixnum;//把之前 前缀 下面的节点数量全加上 并且指针挪到当前前缀
            }
        }
        return prefix;
    }

    public int staticnum(int n, long prefix){
        long next = prefix + 1;
        int count = 0;
        while(prefix <= n){
            count += Math.min(n+1, next) - prefix;
            prefix *= 10;
            next *= 10;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}