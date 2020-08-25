//已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。 
//
// 不要使用系统的 Math.random() 方法。 
//
// 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: 1
//输出: [7]
// 
//
// 示例 2: 
//
// 
//输入: 2
//输出: [8,4]
// 
//
// 示例 3: 
//
// 
//输入: 3
//输出: [8,1,10]
// 
//
// 
//
// 提示: 
//
// 
// rand7 已定义。 
// 传入参数: n 表示 rand10 的调用次数。 
// 
//
// 
//
// 进阶: 
//
// 
// rand7()调用次数的 期望值 是多少 ? 
// 你能否尽量少调用 rand7() ? 
// 
// Related Topics Random Rejection Sampling 
// 👍 105 👎 0


package leetcode.editor.cn;

//java:用 Rand7() 实现 Rand10()
public class P470ImplementRand10UsingRand7 {
    public static void main(String[] args) {
//        Solution solution = new P470ImplementRand10UsingRand7().new Solution();
    }

    public int rand7() {
        return 0;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
//    class Solution extends SolBase {
//        //    public int rand10() {
////        int row, col, idx;
////        do {
////            row = rand7();
////            col = rand7();
////            idx = col + (row - 1) * 7;
////        } while (idx > 40);
////        return 1 + (idx - 1) % 10;
////    }
//        public int rand10() {
//            while (true) {
//                int num = (rand7() - 1) * 7 + rand7();
//                // 如果在40以内，那就直接返回
//                if (num <= 40) return 1 + num % 10;
//                // 说明刚才生成的在41-49之间，利用随机数再操作一遍
//                num = (num - 40 - 1) * 7 + rand7();
//                if (num <= 60) return 1 + num % 10;
//                // 说明刚才生成的在61-63之间，利用随机数再操作一遍
//                num = (num - 60 - 1) * 7 + rand7();
//                if (num <= 20) return 1 + num % 10;
//            }
//        }
//
//    }
//leetcode submit region end(Prohibit modification and deletion)

}