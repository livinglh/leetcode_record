//根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表

  
package leetcode.editor.cn;

import java.util.Stack;

//java:每日温度
public class P739DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 1. 遍历
//        int length = T.length;
//        int[] result = new int[length];
//
//        //从右向左遍历
//        for (int i = length - 2; i >= 0; i--) {
//            // j+= result[j]是利用已经有的结果进行跳跃
//            for (int j = i + 1; j < length; j+= result[j]) {
//                if (T[j] > T[i]) {
//                    result[i] = j - i;
//                    break;
//                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
//                    result[i] = 0;
//                    break;
//                }
//            }
//        }
//
//        return result;

        //2. 单调栈
        int len = T.length;
        int[] res = new int[len];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len ; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int cur = stack.pop();
                res[cur] = i - cur;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int cur = stack.pop();
            res[cur] = 0;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}