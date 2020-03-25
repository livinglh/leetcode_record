//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:序列化二叉树
public class P面试题37XuLieHuaErChaShuLcof{
    public static void main(String[] args) {
        //Solution solution = new P面试题37XuLieHuaErChaShuLcof().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
//    public class Codec {
//        private String results; // 定义一个成员变量存储序列化结果
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            if (root == null) {
//                return "[]";
//            } // root为null直接返回空字符串即可
//
//            // 创建一个队列存储每一个非null节点
//            Queue<TreeNode> queue = new LinkedList<TreeNode>();
//            queue.offer(root); // 将root先放进去
//            results = "[" + root.val;
//            while(!queue.isEmpty()) {
//                // 每次从队列中取出一个节点，根据其左右子节点是否为null进行字符串拼接
//                TreeNode tmp = queue.poll();
//                if (tmp.left != null) {
//                    queue.offer(tmp.left);
//                    results += "," + tmp.left.val;
//                } else {
//                    results += ",null";
//                }
//                // 上面处理left，下面处理right
//                if (tmp.right != null) {
//                    queue.offer(tmp.right);
//                    results += "," + tmp.right.val;
//                } else {
//                    results += ",null";
//                }
//            }
//            // 处理完成之后添加上结束符
//            results += "]";
//            return results;
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            if (data.length() == 2) {
//                return null;
//            }
//
//            // 去除收尾的中括号字符
//            data = data.substring(1, data.length() - 1);
//            // 利用逗号分隔符获取每一个节点的值
//            String[] vals = data.split(",");
//            // 定义队列存储每一个有效节点，为了构建其左右子节点
//            Queue<TreeNode> queue = new LinkedList<TreeNode>();
//            TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
//            queue.offer(root); // 第一个元素为root节点
//            int i = 1; // 标记后续处理的节点值（包含null）
//            while (!queue.isEmpty()) {
//                TreeNode tmp = queue.poll();
//                // 从队列中取出节点，然后根据是否为null，依次设置left和right
//                // 如果不是null，则需要加入队列，后续需要处理此有效节点的左右节点
//                if (vals[i].equals("null")) {
//                    tmp.left = null;
//                } else {
//                    tmp.left = new TreeNode(Integer.valueOf(vals[i]));
//                    queue.offer(tmp.left);
//                }
//                i++;
//                if (vals[i].equals("null")) {
//                    tmp.right = null;
//                } else {
//                    tmp.right = new TreeNode(Integer.valueOf(vals[i]));
//                    queue.offer(tmp.right);
//                }
//                i++;
//            }
//
//            return root;
//        }
//    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder res=mySeri(root,new StringBuilder());
            return res.toString();
        }

        public StringBuilder mySeri(TreeNode root,StringBuilder sb){
            if(root==null){
                sb.append("null,");
                return sb;
            }
            else if(root!=null){
                sb.append(root.val);
                sb.append(",");

                mySeri(root.left,sb);
                mySeri(root.right,sb);
            }
            return sb;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String []temp=data.split(","); // 将序列化的结果转为字符串数组
            List<String> list=new LinkedList<>(Arrays.asList(temp)); // 字符串数组转为集合类 便于操作
            return myDeSeri(list);
        }
        public TreeNode myDeSeri(List<String> list){
            TreeNode root;
            if(list.get(0).equals("null")){
                list.remove(0); // 删除第一个元素 则第二个元素成为新的首部 便于递归
                return null;
            }
            else{
                root=new TreeNode(Integer.valueOf(list.get(0)));
                list.remove(0);
                root.left=myDeSeri(list);
                root.right=myDeSeri(list);
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}