//设计一个支持以下两种操作的数据结构： 
//
// void addWord(word)
//bool search(word)
// 
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。 
//
// 示例: 
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// 说明: 
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。 
// Related Topics 设计 字典树 回溯算法

  
package leetcode.editor.cn;


//java:添加与搜索单词 - 数据结构设计
public class P211AddAndSearchWordDataStructureDesign{
    public static void main(String[] args) {
        //Solution solution = new P211AddAndSearchWordDataStructureDesign().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    class TreeNode {
        TreeNode[] children;
        boolean isEnd;
        public TreeNode(){
            isEnd = false;
            children = new TreeNode[26];
            for (int i = 0; i < 26 ; i++) {
                children[i] = null;
            }
        }
    }
    /** Initialize your data structure here. */

    TreeNode root;
    public WordDictionary() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] array = word.toCharArray();
        TreeNode cur = root;
        for (char c:array) {
            if(cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TreeNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchhelp(word, root);
    }

    public boolean searchhelp(String word, TreeNode root){
        char[] array = word.toCharArray();
        TreeNode cur = root;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if(cur.children[j] != null) {
                        if (searchhelp(word.substring(i + 1), cur.children[j]))
                            return true;
                    }
                }
                return false;
            }
            if(cur.children[array[i]-'a'] == null) return false;
            cur = cur.children[array[i]-'a'];
        }
        return cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}