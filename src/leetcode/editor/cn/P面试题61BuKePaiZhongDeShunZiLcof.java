//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
//

  
package leetcode.editor.cn;

import java.util.*;

//java:扑克牌中的顺子
public class P面试题61BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题61BuKePaiZhongDeShunZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[14];
        for (int i = 0; i < 5; i++) {
            if(nums[i] == 0) continue;
            else{
                if(visited[nums[i]] == true) return false;
                visited[nums[i]] = true;
                if(nums[i] < min) min = nums[i];
                if(nums[i] > max) max = nums[i];
            }
        }
        if(max - min <= 4) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}