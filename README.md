# leetcode_record

---
## 数组：
10_01 121 122 1013 1 2 3 4 15 

- 15 三数之和 排序 双指针
- 169 多数元素 哈希表
- 300 最长上升子序列 动态规划
- 11 盛水最多的容器 双指针
- 17 电话号码的字母组合 递归
- 31 下一个排列 数组 字典序
- 1160 拼写单词 数组 哈希表
- 945 使数组唯一的最小增量 
## 链表
- 19 删除链表倒数第N个节点 双指针
- 876 链表
## 栈
- 有效的括号 栈
---
## 字符串：

- 1071 字符串的最大公因子 辗转相除 
- 5 最长回文子串 中心扩展法 动态规划
- 01_06 字符串压缩 模拟过程 双指针
---

## 二叉树：
543 二叉树直径

---
## 哈希表与字符串：
3，49，76，187，290，409

---
## 搜索（DFS BFS 优先级队列）：
126，127，290，473，407，200 
994
- 695 岛屿的最大面积 深搜，广搜
- 22 括号生成 回溯
- 39 组合总和 回溯 剪枝
- 46 全排列 递归
- 365 水壶问题 DFS 数学
---
## 动态规划：
70，198，53，322，120，300，174
- 17_16 按摩师 动态规划
- 198 打家劫舍I
- 213 打家劫舍II
- 337 打家劫舍III
---
## 复杂数据结构：
208，211，547

208：前缀树，字典树

211：字典树，回溯

547：DFS，BFS，并查集，回溯

307：线段树

---
## 数学 
1103， 1103
- 892 三维形体的表面积

---
## 剑指offer 第2版
03，04，05，06，07,09,10I,10II,11,57，57-2，59-2，12
- 57，57-2：数组，双指针
- 59-2：双端队列
- 12 矩阵中的路径 DFS
- 13 机器人的运动范围 矩阵搜索 DFS BFS
- 14_1 剪绳子 整数分解 动态规划 递归 找规律
- 14_2 剪绳子II 整数分解II 找规律 贪心
- 15 二进制中1的个数 n&=(n-1)可以消除n的最后一位1
- 16 数值的整数次方 快速幂 
- 17 打印从1到最大的n位数
- 18 删除链表的节点
- 19 正则表达式匹配
- 20 表示数值的字符串 数学
- 21 调整数组顺序使奇数位于偶数前面
- 22 链表中倒数第k个节点 双指针
- 24 反转链表
- 25 合并两个排序的链表
- 26 树的子结构 递归
- 27 二叉树的镜像 递归
- 28 对称的二叉树 递归
- 29 顺时针打印矩阵 模拟
- 30 包含min函数的栈 辅助栈
- 31 栈的压入，弹出序列
- 32 I，II，III 从上到下打印二叉树
- 33 二叉搜索树的后序遍历
- 34 二叉树中和为某一值的路径 前序遍历
- 35 复杂链表的复制 哈希表
- 36 二叉搜索树与双向链表 中序遍历
- 37 序列化二叉树 DFS BFS
- 38 字符串的排列 全排列 递归
- 40 最小的k个数 快排 堆

## leetcode

| Title-Link                                                   | Describe                                                     | Method                       | Note |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------------------- | ---- |
| [820 单词的压缩编码](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P820ShortEncodingOfWords.java) | 对有公共后缀的字符串合并                                     | 字典树（后缀版） Hashset去重 |      |
| [1162 地图分析](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P1162AsFarFromLandAsPossible.java) | 二维数组，0为海洋，1为陆地，寻找距离陆地最远的海洋，返回最远距离 | BFS，多源BFS                 |      |

## 剑指_2

| Title-Link                                                   | Describe                                                     | Method                                       | Note |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------------------------------------------- | ---- |
| [39 数组中出现次数超过一半的数字](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题39ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof.java) | 数组中出现次数超过一半的数字                                 | 排序，取中间 摩尔投票法                      |      |
| [40 最小的k个数](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题40ZuiXiaoDeKgeShuLcof.java) | 获得数组中最小的k个数                                        | 快排 大根堆 二叉搜索树                       |      |
| [41 数据流中的中位数](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题41ShuJuLiuZhongDeZhongWeiShuLcof.java) | 设计一个支持以下添加和返回中位数的数据结构                   | 动态维护一个大根堆和小根堆 二分查找+插入排序 |      |
| [42 连续子数组的最大和](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题42LianXuZiShuZuDeZuiDaHeLcof.java) | 连续子数组的最大和                                           | 动态规划                                     |      |
| [43 1～n整数中1出现的次数](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题43OneNzhengShuZhong1chuXianDeCiShuLcof.java) | 输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次 | 数学 递归                                    |      |
| [44 数字序列中某一位的数字](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题44ShuZiXuLieZhongMouYiWeiDeShuZiLcof.java) | 以0123456789101112131415…的格式序列化，求任意第n位对应的数字 | 数学                                         |      |
| [45 把数组排成最小的数](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题45BaShuZuPaiChengZuiXiaoDeShuLcof.java) | 拼接数组中的数字，取最小                                     | 字符串数组排序                               |      |
| [46 把数字翻译成字符串](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题46BaShuZiFanYiChengZiFuChuanLcof.java) | 给定映射关系，计算一个数字有多少种不同的翻译方法             | 动态规划                                     |      |
| [47 礼物的最大价值](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题47LiWuDeZuiDaJieZhiLcof.java) | 二维数组，向右向下，求路径和最大值                           | 动态规划 递归                                |      |
| [48 最长不重复子字符串](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof.java) | 从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度 | 滑动窗口（双指针） 动态规划                  |      |
| [49 丑数](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题49ChouShuLcof.java) | 包含因子 2、3 和 5 的数称作丑数（Ugly Number），求从小到大的的第 n 个丑数 | 动态规划  Treeset                            |      |
| [50 第一次只出现一次的字符](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题50DiYiGeZhiChuXianYiCiDeZiFuLcof.java) | 字符串中第一次只出现一次的字符                               | 哈希表                                       |      |
| [51 数组中的逆序对](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题51ShuZuZhongDeNiXuDuiLcof.java) | 数组中逆序对的数量                                           | 归并排序                                     |      |
| [52 两个链表的第一个公共节点](P面试题52LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof.java) | 两个链表的第一个公共节点                                     | 链表基本操作                                 |      |
| [53I 排序数组中查找数字](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题53IZaiPaiXuShuZuZhongChaZhaoShuZiLcof.java) | 排序数组中查找数字                                           | 二分查找（左右边界）                         |      |
| [53II 0～n-1中缺失的数字](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题53IIQueShiDeShuZiLcof.java) | 0～n-1中缺失的数字                                           | 二分查找（右边界）                           |      |
| [54 二叉搜索树的第k大节点](https://github.com/livinglh/leetcode_record/blob/master/src/leetcode/editor/cn/P面试题54ErChaSouSuoShuDeDiKdaJieDianLcof.java) | 二叉搜索树的第k大节点                                        | 中序遍历改                                   |      |



