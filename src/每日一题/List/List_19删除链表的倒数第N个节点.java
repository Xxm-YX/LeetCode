package 每日一题.List;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class List_19删除链表的倒数第N个节点 {

    public static class ListNode {
      int val;
        public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

        int count = 0;  //位置
        ListNode target = new ListNode(); //目标节点
        boolean is = true;  //是否是第一个节点
        ListNode headl = new ListNode(); // 头节点
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(n == 0 || head == null){
                return null;
            }

            if( is ){     //记录第一个节点
                headl = head;
            }

            if(n == 1 && is && head.next == null){  //如果 只有一个节点，然后要移除这个一个节点
                return null;
            }

            if(head == null){
                return head;
            }

            is = false;    //进入递归前
            removeNthFromEnd(head.next,n);
            count++;  //递归出来后，数量加1

            //当前是第n个节点
            if(count == n){   //如果是目标节点 记录下来
                target = head;
            }

            if(count == n && head == headl){  //如果是 从最后一个开始数，数到第一个节点要移除
                head = head.next;
            }

            if(count == n+1){
                head.next = target.next;
                target.next = null;
            }
            return head;
        }

    /**
     * 方法二：快慢指针  （最巧妙的写法）
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
       ListNode res = new ListNode(0,head);
       ListNode fast = res;
       ListNode slow = res;
        for (int i = 0; i < n; i++) {
            fast= fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return res.next;
    }

    /**
     * 方法三：计算链表长度
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        int length = getLength(head);
        ListNode temp = dummy;
        for (int i = 0; i < length-n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head){
        int count = 1;
        while(head.next != null){
            head = head.next;
            count++;
        }
        return count;
    }


    /**
     * 方法四：栈
     */
    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        Deque<ListNode> path = new LinkedList<>();
        ListNode cur = dummy;

        while(cur!=null){
            path.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            path.poll();
        }
        ListNode prev = path.peek();
        prev.next = prev.next.next;
        return dummy.next;

    }
}
