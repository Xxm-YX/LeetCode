package 每日一题.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class List_234回文链表 {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
  }

    /**
     * 递归
     * @param head
     * @return
     */
    private ListNode frontPointer;
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if(head != null){
            if(!dfs(head.next)){
                return false;
            }
            //到这一步，就已经是最后一个了
            if(head.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 加到数组中，再双指针比较
     */
    public boolean isPalindrome1(ListNode head) {
        List<Integer> path = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            path.add(temp.val);
            temp = temp.next;
        }
        int i = 0, j = path.size()-1;

        while(i <= j){
            boolean a = !path.get(i).equals(path.get(j));
            if(a){
                return false;
            }else {
                i++;
                j--;
                continue;
            }
        }
        return true;
    }

    /**
     * 快慢指针,寻到中间节点
     */
    public boolean isPalindrome2(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //这个时候找到了右半部分的第一个节点

        slow = rever(slow);

        while( slow != null){
            if(slow.val != head.val){
                return false;
            }else {
                slow = slow.next;
                head = head.next;
            }
        }
        return true;

    }

    private ListNode rever(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode temp = rever(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }
}
