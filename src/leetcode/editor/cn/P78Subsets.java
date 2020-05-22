//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //    public List<List<Integer>> subsets(int[] nums) {
//        //1. 回溯
//        List<List<Integer>> ans = new ArrayList<>();
//        backtrack(0,nums,ans,new ArrayList<Integer>());
//        return ans;
//    }
//    public void backtrack(int start, int[] nums, List<List<Integer>> ans, List<Integer> track){
//        ans.add(new ArrayList<>(track));
//        for (int i = start; i < nums.length; i++) {
//            track.add(nums[i]);
//            backtrack(i+1, nums, ans, track);
//            track.remove(track.size()-1);
//        }
//    }
        //2. 二进制和位运算
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < (1 << nums.length); i++) {
                List<Integer> sub = new ArrayList<>();
                for (int j = 0; j < nums.length; j++)
                    if (((i >> j) & 1) == 1) sub.add(nums[j]);
                res.add(sub);
            }
            return res;
        }
//        //3. 递归枚举
//        public List<List<Integer>> subsets(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            res.add(new ArrayList<>());
//            for (Integer n : nums) {
//                int size = res.size();
//                for (int i = 0; i < size; i++) {
//                    List<Integer> newSub = new ArrayList<>(res.get(i));
//                    newSub.add(n);
//                    res.add(newSub);
//                }
//            }
//            return res;
//        }
        //4. DFS 中序
//            public void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
//                if (i >= nums.length) return;
//                subset = new ArrayList<Integer>(subset);
//
//                inOrder(nums, i + 1, subset, res);
//                subset.add(nums[i]);
//                // 这里
//                res.add(subset);
//                inOrder(nums, i + 1, subset, res);
//            }

    }
//leetcode submit region end(Prohibit modification and deletion)

}