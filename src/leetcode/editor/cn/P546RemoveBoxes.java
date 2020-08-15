//给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。 
//你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分
//。 
//当你将所有盒子都去掉之后，求你能获得的最大积分和。 
//
// 
//
// 示例： 
//
// 输入：boxes = [1,3,2,2,2,3,4,3,1]
//输出：23
//解释：
//[1, 3, 2, 2, 2, 3, 4, 3, 1] 
//----> [1, 3, 3, 4, 3, 1] (3*3=9 分) 
//----> [1, 3, 3, 3, 1] (1*1=1 分) 
//----> [1, 1] (3*3=9 分) 
//----> [] (2*2=4 分)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= boxes.length <= 100 
// 1 <= boxes[i] <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 154 👎 0

  
package leetcode.editor.cn;
//java:移除盒子
public class P546RemoveBoxes{
    public static void main(String[] args) {
        Solution solution = new P546RemoveBoxes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeBoxes(int[] boxes) {
            int[][][] dp = new int[100][100][100];
            return calculatePoints(boxes, dp, 0, boxes.length - 1, 0);
        }

        public int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
            if (l > r) return 0;
            if (dp[l][r][k] != 0) return dp[l][r][k];
            while (r > l && boxes[r] == boxes[r - 1]) {
                r--;
                k++;
            }

            // 策略一：我们可以直接点boxes[r]，把最后相同的盒子一次性消除
            dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
            // 策略二：把夹在中间的杂鱼盒子都消掉，让后面连起来的盒子数更多
            for (int i = l; i < r; i++) {
                if (boxes[i] == boxes[r]) {
                    dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0));
                }
            }
            return dp[l][r][k];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}