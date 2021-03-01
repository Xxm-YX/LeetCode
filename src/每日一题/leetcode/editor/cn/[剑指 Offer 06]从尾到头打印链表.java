package 每日一题.leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 95 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class CongWeiDaoTouDaYinLianBiaoLcof{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        solution.reversePrint(listNode);
    }

//leetcode submit region begin(Prohibit modification and deletion)




class Solution {
    /**
     * 栈
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int i =0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop().val;
        }
        return res;
    }

    /**
     * 递归
     */
    public int[] reversePrint3(ListNode head) {
        ArrayList<Integer> integers = printListFromTailToHead(head);
        int i = 0;
        int[] res = new int[integers.size()];
        for (Integer integer : integers) {
            res[i++] = integer;
        }
        return res;
    }

    private ArrayList<Integer> printListFromTailToHead(ListNode head){
        ArrayList<Integer> ret = new ArrayList<>();
        if(head != null){
            ret.addAll(printListFromTailToHead(head.next));
            ret.add(head.val);
        }
        return ret;
    }

    /**
     * 递归
     */
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint4(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        // 正向遍历即可，在list中，元素已经反转
        for(int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
    // 递归的方式
    public void recur(ListNode head){
        if(head == null) return;
        recur(head.next);
        // add操作要在递归函数之后
        // 第一次add操作，就是最后一次递归结束的时候
        list.add(head.val);
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {

        ListNode node = new ListNode(-1);
        int size = 0;
        while(head != null){
            size++;
            ListNode memo = head.next;
            head.next = node.next;
            node.next = head;
            head = memo;
        }

        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = node.next.val;
            node = node.next;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}