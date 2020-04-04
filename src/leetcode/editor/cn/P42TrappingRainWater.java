//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

  
package leetcode.editor.cn;

import java.util.Stack;

//java:接雨水
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 逐个遍历
//        int ans = 0;
//        for (int i = 1; i < height.length-1; i++) {
//            int max_left = 0;
//            for (int j = i-1; j >= 0 ; j--) {
//                max_left = Math.max(max_left, height[j]);
//            }
//            int max_right = 0;
//            for (int j = i+1; j < height.length; j++) {
//                max_right = Math.max(max_right,height[j]);
//            }
//            int min_all = Math.min(max_left,max_right);
//            if(height[i] < min_all){
//                ans += (min_all - height[i]);
//            }
//        }
//        return ans;
        // 动态规划 求得左右两边最大的
//        int ans = 0;
//        int[] max_left = new int[height.length];
//        int[] max_right = new int[height.length];
//        for (int i = 1; i < height.length; i++) {
//            max_left[i] = Math.max(max_left[i-1], height[i-1]);
//        }
//        for (int i = height.length-2; i >= 0 ; i--) {
//            max_right[i] = Math.max(max_right[i+1], height[i+1]);
//        }
//        for (int i = 1; i < height.length - 1; i++) {
//            int min = Math.min(max_left[i], max_right[i]);
//            if(min > height[i]){
//                ans += min - height[i];
//            }
//        }
//        return ans;
        // 双指针
//        int sum = 0;
//        int max_left = 0;
//        int max_right = 0;
//        int left = 1;
//        int right = height.length - 2; // 加右指针进去
//        for (int i = 1; i < height.length - 1; i++) {
//            //从左到右更
//            if (height[left - 1] < height[right + 1]) {
//                max_left = Math.max(max_left, height[left - 1]);
//                int min = max_left;
//                if (min > height[left]) {
//                    sum = sum + (min - height[left]);
//                }
//                left++;
//                //从右到左更
//            } else {
//                max_right = Math.max(max_right, height[right + 1]);
//                int min = max_right;
//                if (min > height[right]) {
//                    sum = sum + (min - height[right]);
//                }
//                right--;
//            }
//        }
//        return sum;

        // 单调栈
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
// 以最大值分界，左边非减，右边非增  C++版
//    class Solution {
//        public:
//        //以最大值分界，左边非减，右边非增
//        int trap(vector<int>& height) {
//            int n=height.size();
//            if(n==0) return 0;
//            int m=max_element(height.begin(),height.end())-height.begin();
//            //遍历最大值左边
//            int res=0,cur=height[0];
//            for(int i=1;i<m;i++)
//            {
//                if(height[i]<cur)
//                    res+=cur-height[i];
//                else
//                    cur=height[i];
//            }
//            //遍历最大值右边
//            cur=height[n-1];
//            for(int i=n-2;i>m;i--)
//            {
//                if(height[i]<cur)
//                    res+=cur-height[i];
//                else
//                    cur=height[i];
//            }
//            return res;
//        }
//    };

//leetcode submit region end(Prohibit modification and deletion)

}