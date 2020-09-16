package 笔试题.新浪9_13;

import java.util.*;

/*
1,2,3,4,5,6,7
 */
public class Main1 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }
    static TreeNode newroot;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] nums = new int[str.length+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str[i-1]);
        }

        int n = nums.length - 1;
        TreeNode root = null;
        Map<Integer, TreeNode> map = new HashMap<>();
        //建立原二叉树
        for (int i = 1; i <= n/2; i++) {
            TreeNode curnode;
            if(map.containsKey(i)){
                curnode = map.get(i);
            }else{
                curnode = new TreeNode(nums[i]);
                map.put(i, curnode);
            }
            if(i * 2 <= n){
                TreeNode left;
                if(map.containsKey(i * 2)){
                    left = map.get(i * 2);
                }else{
                    left = new TreeNode(nums[i * 2]);
                    map.put(i * 2, left);
                }
                curnode.left = left;
            }
            if(i * 2 + 1 <= n){
                TreeNode right;
                if(map.containsKey(i * 2 + 1)){
                    right = map.get(i * 2 + 1);
                }else{
                    right = new TreeNode(nums[i * 2 + 1]);
                    map.put(i * 2+1, right);
                }
                curnode.right = right;
            }
            if(i == 1){
                root = curnode;
            }
        }

        //DFS(root);

        TreeNode parent = null, parent_right = null;
        while(root != null){
            TreeNode left = root.left;
            root.left = parent_right;
            parent_right = root.right;
            root.right = parent;
            parent = root;
            root = left;
        }

        newroot = parent;
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(newroot);
        while(!queue.isEmpty()){
            TreeNode curnode = queue.poll();
            index++;
            if(index != n){
                System.out.print(curnode.val + ",");
            }else{
                System.out.print(curnode.val);
            }
            if(curnode.left!=null){
                queue.offer(curnode.left);
            }
            if(curnode.right!=null){
                queue.offer(curnode.right);
            }
        }

    }


    public static TreeNode DFS(TreeNode node){
        if(node == null){
            return null;
        }
        //后续第一个叶子节点
        if(node.left == null && node.right == null){
            if(newroot == null){
                newroot = node;
            }
            return node;
        }

        TreeNode left = DFS(node.left);
        TreeNode right = DFS(node.right);
        if(left != null){
            left.left = right;
            left.right = node;
        }

        node.left = null;
        node.right = null;
        return node;
    }
}
