//还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴
//都要用到。 
//
// 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,2,2]
//输出: true
//
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: [3,3,3,3,4]
//输出: false
//
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 注意: 
//
// 
// 给定的火柴长度和在 0 到 10^9之间。 
// 火柴数组的长度不超过15。 
// 
// Related Topics 深度优先搜索

  
package leetcode.editor.cn;

import java.util.*;

//java:火柴拼正方形
public class P473MatchsticksToSquare{
    public static void main(String[] args) {
        Solution solution = new P473MatchsticksToSquare().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            newNums[i] = nums[i];
        }
        if(sum%4!=0 || nums.length<4) return false;
        Arrays.sort(newNums, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        int ech = sum / 4;
        int[] lines = new int[4];
        return dfs(0,newNums,lines,ech);
    }

    public boolean dfs(int index,Integer[] nums,int[] lines,int ech){
        if(index == nums.length){
            return lines[0] == ech && lines[1] == ech && lines[2] == ech && lines[3] == ech;
        }
        for (int i = 0; i < 4; i++) {
            if(lines[i] + nums[index] > ech) continue;
            lines[i] += nums[index];
            if(dfs(index+1,nums,lines,ech)) return true;
            lines[i] -= nums[index];
        }
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}