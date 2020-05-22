//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//java:最长连续序列
public class P128LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        // 1. 哈希表 On
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums) set.add(num);
        for(int num : nums){
            if(!set.contains(num-1)){
                int curNum = num;
                int curLen = 1;
                while(set.contains(curNum+1)){
                    curNum ++;
                    curLen ++;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
        // 2. 排序 Onlogn
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}