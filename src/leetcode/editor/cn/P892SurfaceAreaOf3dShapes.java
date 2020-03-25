//在 N * N 的网格上，我们放置一些 1 * 1 * 1 的立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。 
//
// 请你返回最终形体的表面积。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[[2]]
//输出：10
// 
//
// 示例 2： 
//
// 输入：[[1,2],[3,4]]
//输出：34
// 
//
// 示例 3： 
//
// 输入：[[1,0],[0,2]]
//输出：16
// 
//
// 示例 4： 
//
// 输入：[[1,1,1],[1,0,1],[1,1,1]]
//输出：32
// 
//
// 示例 5： 
//
// 输入：[[2,2,2],[2,1,2],[2,2,2]]
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数学

  
package leetcode.editor.cn;
//java:三维形体的表面积
public class P892SurfaceAreaOf3dShapes{
    public static void main(String[] args) {
        Solution solution = new P892SurfaceAreaOf3dShapes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int surfaceArea(int[][] grid) {
        int n =  grid.length, ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int val = grid[i][j];
                if(val > 0){
                    ans += (val << 2) + 2;
                    ans -= i > 0 ? Math.min(val, grid[i-1][j]) << 1 : 0;
                    ans -= j > 0 ? Math.min(val, grid[i][j-1]) << 1 : 0;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}