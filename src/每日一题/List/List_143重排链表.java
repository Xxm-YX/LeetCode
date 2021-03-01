package 每日一题.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class List_143重排链表 {
    public static class ListNode {
        public  int val;
        public ListNode next;
        public ListNode() {}
      public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 存储
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        //存到list中去
        List<ListNode> list = new ArrayList<>();
        while (head != null) {

            list.add(head);
            head = head.next;
        }
        //从头指针依次取元素
        int i =0,j = list.size()-1;
        while(i < j){
            list.get(i).next = list.get(j);
            i++;
            //偶数个节点的情况，会提前相遇
            if( i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     *寻找链表中点 + 链表逆序 + 合并链表
     * @param head
     */
    public void reorderList2(ListNode head) {

        if(head == null){
            return;
        }
        //寻找中间结点
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        //反转 右端链表
        l2 = reverseList(l2);

        mergeList(l1,l2);
    }

    /**
     * 合并两个链表
     * @param l1
     * @param l2
     */
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_next;
        ListNode l2_next;

        while(l1 != null && l2 != null){
            l1_next = l1.next;
            l2_next = l2.next;

            l1.next = l2;
            l1 = l1_next;

            l2.next = l1;
            l2 = l2_next;
        }


    }

    /**
     * 反转右端链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nexttemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nexttemp;
        }
        return pre;
    }

    //快慢指针 找到中间节点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针，找到中间节点
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /****************************************************/

    public void reorderList3(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        //链表节点长度
        int len = 0;

        ListNode h = head;
        //求出节点数
        while(h != null){
            len++;
            h = h.next;
        }

        dfs(head,len);

    }

    private ListNode dfs(ListNode head, int len) {

        //两个出口 这是两个情况，len=1 时，说明到最后一个
        if(len == 1){
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if(len == 2){  // len=2 时。最后一个也没有地方给你插了
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //这个开始递归，将头节点和尾节点之间的链表
        //这里也是快慢指针的思想，len-2，head=head.next 最后得到中间节点
        //head就是中间节点。根据数量返回最后一个节点
        ListNode tail = dfs(head.next,len-2);
        ListNode subHead = head.next;//中间头节点 的下一个
        head.next = tail;
        ListNode outTail = tail.next; //上一层 head对应的tail
        tail.next = subHead;
        return outTail;
    }

}
