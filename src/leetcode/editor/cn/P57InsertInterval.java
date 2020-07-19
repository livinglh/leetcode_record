//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组 
// 👍 166 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//java:插入区间
public class P57InsertInterval{
    public static void main(String[] args) {
        Solution solution = new P57InsertInterval().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] > newInterval[1] || intervals[i][1] < newInterval[0]){
                ans.add(intervals[i]);
            }else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        int[][] res = new int[ans.size() + 1][2];
        int index = 0;
        boolean flag = true; // 表示是否加入
        for(int[] each : ans){
            if(each[0] == newInterval[0] && each[1] == newInterval[1]){
                flag = true;
            }
            res[index++] = each;
        }
        if(flag) res[index++] = newInterval;
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}