//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
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
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//java:二叉树的序列化与反序列化
public class P297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        //Solution solution = new P297SerializeAndDeserializeBinaryTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder res=mySeri(root,new StringBuilder());
            return res.toString();
        }
        StringBuilder mySeri(TreeNode root,StringBuilder sb){
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