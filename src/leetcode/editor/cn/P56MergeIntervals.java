//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//java:合并区间
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 整体排序后合并
//    public int[][] merge(int[][] intervals) {
//        if(intervals.length <= 1) return intervals;
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        List<int[]> ans = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            if(i == intervals.length-1 || intervals[i+1][0] > intervals[i][1]){
//                ans.add(intervals[i]);
//            }
//            else{
//                intervals[i+1][0] = intervals[i][0];
//                intervals[i+1][1] = Math.max(intervals[i+1][1], intervals[i][1]);
//            }
//        }
//        return ans.toArray(new int[ans.size()][]);
//    }
        // 遍历合并
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;

        int cnt = 0; // 合并次数
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null; // 清空前者
                    cnt++;
                    break;
                }
            }
        }

        int[][] res = new int[len - cnt][2]; // len - cnt 合并后个数
        int ri = 0;
        for (int[] pair : intervals) {
            if (pair != null) res[ri++] = pair;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}