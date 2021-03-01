package 每日一题.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 */
public class List_24两两交换链表中的节点 {

    public static class ListNode {
      int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }

        ListNode pre = new ListNode(); // 用来控制前驱节点
        pre.next = head;
        ListNode cur = head;//用了控制当前节点
        ListNode next = head.next;//用来控制后驱节点
        int a = 1;//标记头节点的转换

        while(cur.next != null && cur.next.next != null){
            cur.next = next.next;
            next.next = cur;

            pre.next = next;
            if(a == 1){
                head = next;
                a--;
            }

            cur = cur.next;
            next = next.next.next.next;
            pre = pre.next.next;
        }

        if(cur.next != null){
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            if(a == 1){
                head = next;
                a--;
            }
        }



        return head;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    /**
     * 递归
     */
        public ListNode swapPairs2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }



}
