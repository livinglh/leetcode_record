//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 352 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

// java: 把数组排成最小的数
public class P剑指Offer45BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer45BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            String[] str = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                str[i] = String.valueOf(nums[i]);
            }
            // Arrays.sort(str, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
            // 快排
            quickSort(str, 0, nums.length - 1);
            StringBuilder res = new StringBuilder();
            for (String s : str) {
                res.append(s);
            }
            return res.toString();
        }

        public void quickSort(String[] str, int l, int r) {
            if (l >= r) {
                return;
            }
            String piv = str[l];
            int lr = l;
            for (int i = l + 1; i <= r; i++) {
                if ((str[i] + piv).compareTo(piv + str[i]) < 0) {
                    lr++;
                    swap(str, lr, i);
                }
            }
            swap(str, l, lr);
            quickSort(str, l, lr - 1);
            quickSort(str, lr + 1, r);
        }

        public void swap(String[] str, int i, int j) {
            String tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}