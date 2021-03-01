package 每日一题.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class List_148排序链表 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    /**
     * API排序方法
     * @param head
     * @return
     */
        public ListNode sortList1(ListNode head) {
            if (head == null) return null;
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            Collections.sort(list, (n1, n2) -> n1.val - n2.val);
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
            list.get(list.size() - 1).next = null;
            return list.get(0);
        }

    /**
     * 自上而下 归并排序
      * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);

        ListNode res = h ;

        while(left != null && right != null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    /**
     * 归并。自低向上
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0,head);
        //每次subLengthx2
        for (int subLength = 1; subLength < length; subLength<<=1) {
            ListNode prev = dummyHead,curr = dummyHead.next;
            while(curr != null){
                //左
                ListNode head1 = curr;
                for(int i = 1;i < subLength && curr.next != null;i++){
                    curr = curr.next;
                }
                //右
                ListNode head2 = curr.next;
                //切断
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                //下一个开始节点
                ListNode next = null;
                if(curr != null){
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1,head2);
                prev.next = merged;
                while(prev.next != null){
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 合并！
     * @param head1
     * @param head2
     * @return
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = head1,temp2 = head2;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null){
            temp.next = temp1;
        }else if(temp2 != null){
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
