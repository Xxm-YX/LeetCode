package 每日一题.List;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以不用额外空间解决此题？
 */
public class List_142环形链表2 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    /**
     * 方法一：Set集合 api
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head== null || head.next == null){
            return null;
        }

        Set<ListNode> path = new HashSet<ListNode>();
        ListNode temp = head;

        path.add(temp);
        while(temp.next != null){
            temp = temp.next;

            if(path.contains(temp)){
                return temp;
            }

            path.add(temp);
        }

        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if(head == null){
            return null;
        }

        //找环的最后一个节点
        ListNode lastNode = findLastNode(head);
        if(lastNode == null){
            return null;
        }

        ListNode temp1 = head;
        ListNode temp2 = lastNode;

        while(temp1 != temp2){
            temp1 = temp2.next;
            temp2 = temp2.next;
        }
        return temp1;

    }

    private ListNode findLastNode(ListNode head) {
        //使用快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
}
