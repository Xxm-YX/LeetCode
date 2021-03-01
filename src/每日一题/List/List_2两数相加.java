package 每日一题.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class List_2两数相加 {

    public static class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode path = res;

        int current = 0;  //需要进位的

        if(l1 == null || l2 == null){
            return res.next;
        }

        while(l1 != null || l2 != null){

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y +current;

            current = sum /10;
            sum = sum %10 ;
            path.next = new ListNode(sum);

            path = path.next;

            if(l1!= null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2 . next;
            }
        }
        if (current == 1) {

            path.next = new ListNode(current);
        }
        return res.next;
    }

}
