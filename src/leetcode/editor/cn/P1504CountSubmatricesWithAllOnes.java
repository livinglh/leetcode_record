//给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,0,1],
//            [1,1,0],
//            [1,1,0]]
//输出：13
//解释：
//有 6 个 1x1 的矩形。
//有 2 个 1x2 的矩形。
//有 3 个 2x1 的矩形。
//有 1 个 2x2 的矩形。
//有 1 个 3x1 的矩形。
//矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[0,1,1,0],
//            [0,1,1,1],
//            [1,1,1,0]]
//输出：24
//解释：
//有 8 个 1x1 的子矩形。
//有 5 个 1x2 的子矩形。
//有 2 个 1x3 的子矩形。
//有 4 个 2x1 的子矩形。
//有 2 个 2x2 的子矩形。
//有 2 个 3x1 的子矩形。
//有 1 个 3x2 的子矩形。
//矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
// 
//
// 示例 3： 
//
// 
//输入：mat = [[1,1,1,1,1,1]]
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows <= 150 
// 1 <= columns <= 150 
// 0 <= mat[i][j] <= 1 
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;
//java:统计全 1 子矩形
public class P1504CountSubmatricesWithAllOnes{
    public static void main(String[] args) {
        Solution solution = new P1504CountSubmatricesWithAllOnes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubmat(int[][] mat) {
        int ans=0;
        int m=mat.length;
        int n=mat[0].length;
        int maxZ[][]=new int[m][n];
        for(int i=0;i<m;i++){
            int maxZuo=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    maxZuo++;
                }
                else{maxZuo=0;}
                maxZ[i][j]=maxZuo;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int rec=150;
                for(int k=i;k>=0;k--){
                    rec=Math.min(rec,maxZ[k][j]);
                    ans+=rec;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}