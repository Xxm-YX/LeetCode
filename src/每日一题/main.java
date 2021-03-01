package 每日一题;

import org.junit.Test;
import 每日一题.Array.*;
import 每日一题.List.*;
import 每日一题.String.String_844比较含退格的字符串;
import 每日一题.String.String_925长按键入;
import 每日一题.动态规划.分割等和子集;

public class main {
    public static void main(String[] args) {
      /*  DFS_216组合总和III a = new DFS_216组合总和III();
        System.out.println(
                a.combinationSum3(3,9)
        );*/

       /* Tree_501二叉搜索树中的众数 t = new Tree_501二叉搜索树中的众数();

        Tree_501二叉搜索树中的众数.TreeNode a = new Tree_501二叉搜索树中的众数.TreeNode(1);

        a.right = new Tree_501二叉搜索树中的众数.TreeNode(2);
        *//*a.right.left = new Tree_538把二叉搜索树转换为累加.TreeNode(15);
        a.right.right  = new Tree_538把二叉搜索树转换为累加.TreeNode(7);*//*

        for (int i : t.findMode(a)) {
            System.out.println(i);
        }*/
//        DFS_37解数独 a = new DFS_37解数独();
//        System.out.println();
//        System.out.println(t.inorderTraversal(a));

      /*  int[][] res = {{1,2}, {3,2}, {2,4},{4,1}};
        Array_685_冗余连接II a = new Array_685_冗余连接II();
        int[] ints = a.findRedundantDirectedConnection(res);
        for (int i : ints) {
            System.out.print(i+" ");
        }*/


        List_2两数相加 a = new List_2两数相加();
        List_2两数相加.ListNode l1 = new List_2两数相加.ListNode(2);
        l1.next = new List_2两数相加.ListNode(4);
        l1.next.next = new List_2两数相加.ListNode(3);

        List_2两数相加.ListNode l2 = new List_2两数相加.ListNode(5);
        l2.next = new List_2两数相加.ListNode(6);
        l2.next.next = new List_2两数相加.ListNode(4);

        System.out.println(a.addTwoNumbers(l1,l2));

    }

    @Test
    public void Test1(){
        _15三数之和 a = new _15三数之和();
        int[] nums = {-2,1,1,1,1,1};
        a.threeSum(nums);
    }

    @Test
    public void Test2(){
        int[] a = {2,0,2,1,1,0};
        Array_75颜色分类 A = new Array_75颜色分类();
        A.sortColors1(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void Test3(){
        char[] s = {'h','e','l','l','o'};
        Array_344反转字符串 a = new Array_344反转字符串();
        a.reverseString(s);
    }

    @Test
    public void Test4(){
        int[] a = {1, 5, 11, 5};
        分割等和子集 b = new 分割等和子集();
        b.canPartition(a);
    }

    @Test
    public void Test5(){
        List_24两两交换链表中的节点 a = new List_24两两交换链表中的节点();

        List_24两两交换链表中的节点.ListNode b = new List_24两两交换链表中的节点.ListNode(1);
        b.next = new List_24两两交换链表中的节点.ListNode(2);
        b.next.next = new List_24两两交换链表中的节点.ListNode(3);
        b.next.next.next = new List_24两两交换链表中的节点.ListNode(4);

        a.swapPairs(b);
    }

    @Test
    public void Test6(){
        LIst_1002查找常用字符 a =new LIst_1002查找常用字符();
        a.commonChars(new String[]{"bella", "label", "roller"});
    }


    @Test
    public void Test7(){
        Array_977有序数组的平方 a = new Array_977有序数组的平方();
        int[] b = {-4,-1,0,3,10};
        a.sortedSquares3(b);
    }

    @Test
    public void Test8(){
        List_51N皇后 a = new List_51N皇后();
        a.solveNQueens4(4);
    }

    @Test
    public void test9(){
        List_19删除链表的倒数第N个节点 a = new List_19删除链表的倒数第N个节点();

        List_19删除链表的倒数第N个节点.ListNode b =  new List_19删除链表的倒数第N个节点.ListNode(1);
        b.next = new List_19删除链表的倒数第N个节点.ListNode(2);

        a.removeNthFromEnd(b,1);
    }

    @Test
    public void test10(){
        String_844比较含退格的字符串 a = new String_844比较含退格的字符串();
        boolean b = a.backspaceCompare("ab##", "c#d#");

        System.out.println(b);

    }

    @Test
    public void test11(){
        List_143重排链表 a = new List_143重排链表();
        List_143重排链表.ListNode b = new List_143重排链表.ListNode(1);
        b.next = new List_143重排链表.ListNode(2);
        b.next.next = new List_143重排链表.ListNode(3);
        b.next.next.next = new List_143重排链表.ListNode(4);
        b.next.next.next.next = new List_143重排链表.ListNode(5);
        b.next.next.next.next.next = new List_143重排链表.ListNode(6);
        a.reorderList3(b);
    }

    @Test
    public void test12(){
        String_925长按键入 a = new String_925长按键入();


        System.out.println(a.isLongPressedName("zlexya","aazlllllllllllllleexxxxxxxxxxxxxxxya"));
    }

    @Test
    public void test13(){
        List_234回文链表 a = new List_234回文链表();
        List_234回文链表.ListNode b = new List_234回文链表.ListNode(1);
        b.next = new List_234回文链表.ListNode(2);
        b.next.next = new List_234回文链表.ListNode(3);
        b.next.next.next = new List_234回文链表.ListNode(2);
        b.next.next.next.next = new List_234回文链表.ListNode(1);
        System.out.println(a.isPalindrome2(b));
    }

    @Test
    public void test14(){
        Array_1024视频拼接 a = new Array_1024视频拼接();

        int[][] b = { {0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};

        a.videoStitching2(b,10);
    }

    @Test
    public void test15(){
        Array_1207独一无二的出现次数 a = new Array_1207独一无二的出现次数();
        a.uniqueOccurrences(new int[]{1,2,2,1,1,3});
    }
}
