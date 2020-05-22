//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法

  
package leetcode.editor.cn;
//java:单词搜索
public class P79WordSearch{
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        solution.exist(new char[][]{{'a','b'},{'c','d'}}, "cdba");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(backtrace(i, j,0, board, word, visited)){
                    return true;
                };
            }
        }
        return false;
    }

    public boolean backtrace(int i, int j, int start, char[][] board, String word, boolean[][] visited){
        if(start >= word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;
        if(board[i][j] == word.charAt(start)){
            visited[i][j] = true;
            for (int k = 0; k < dir.length; k++) {
                if(backtrace(i+dir[k][0], j+dir[k][1], start+1, board, word, visited)){
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}