//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学


package leetcode.editor.cn;

import java.util.HashSet;

//java:直线上最多的点数
public class P149MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new P149MaxPointsOnALine().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            if (points.length < 3) {
                return points.length;
            }
            int i = 0;
            //判断所有点是否都相同的特殊情况
            for (; i < points.length - 1; i++) {
                if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                    break;
                }

            }
            if (i == points.length - 1) {
                return points.length;
            }
            HashSet<String> set = new HashSet<>();
            int max = 0;
            for (i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        continue;
                    }
                    String key = getK(points[i][0], points[i][1], points[j][0], points[j][1])
                            + "@"
                            + getB(points[i][0], points[i][1], points[j][0], points[j][1]);
                    if (set.contains(key)) {
                        continue;
                    }
                    int tempMax = 0;
                    for (int k = 0; k < points.length; k++) {
                        if (k != i && k != j) {
                            if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                                tempMax++;
                            }
                        }

                    }
                    if (tempMax > max) {
                        max = tempMax;
                    }
                    set.add(key);
                }
            }
            return max + 2;
        }

        private double getB(int x1, int y1, int x2, int y2) {
            if (y2 == y1) {
                return Double.POSITIVE_INFINITY;
            }
            return (double) (x2 - x1) * (-y1) / (y2 - y1) + x1;
        }

        private double getK(int x1, int y1, int x2, int y2) {
            if (x2 - x1 == 0) {
                return Double.POSITIVE_INFINITY;
            }
            return (double) (y2 - y1) / (x2 - x1);
        }

        private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
            return (long) (y2 - y1) * (x - x2) == (long) (y - y2) * (x2 - x1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}