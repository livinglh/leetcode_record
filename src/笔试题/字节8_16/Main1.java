package 笔试题.字节8_16;

/*
知道先序遍历、中序遍历，求叶子节点数量
思路：DFS（深度遍历算法），叶子节点也就是只有根节点，无左右孩子节点
步骤：判断是否有左右孩子，若无，返回一个叶子节点。否则，返回右孩子的叶子结点+右孩子的叶子节点数。相应代码如下：


5
3 9 20 15 7
9 3 15 20 7

3
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    static int[] preorder;
    static int[] inorder;
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        preorder = new int[n];
        inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            map.put(inorder[i], i);
        }

        int ans = numDFS(0, n-1, 0, n-1);
        System.out.println(ans);
    }

    public static int numDFS(int prel, int prer, int inl, int inr){
        if(prel > prer || inl > inr) return 0;
        if(prel == prer) {
            return 1;
        }
        int pivot = map.get(preorder[prel]);
        int left = numDFS(prel+1, prel + (pivot - inl), inl, pivot-1);
        int right = numDFS(prel+(pivot-inl)+1, prer, pivot+1, inr);
        return left + right;
    }
}
