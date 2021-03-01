所谓的递归，就是在自己的世界里走了一圈~ 

起点  ----》 多次递归调用  ----》   出口条件  -----》 回调   ----》  最终返回

+ **正向过程**：如果执行操作在递归之前，则在每个正向调用的过程中都执行一遍。
```java
list.add(head.val); // 操作
recur(head.next);  // 递归调用
```
![剑指offer-06-从头打印链表01.jpeg](https://pic.leetcode-cn.com/1612445891-RbWUcI-%E5%89%91%E6%8C%87offer-06-%E4%BB%8E%E5%A4%B4%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A801.jpeg)


+ **回调过程**：但是，如果执行操作在递归之后，就会在最终的递归出口处开始，继续执行没有执行完的操作！有那味道没！哈哈哈

```java
recur(head.next);  // 递归调用
list.add(head.val); // 操作
```

![剑指offer-06-从头打印链表 (1).jpeg](https://pic.leetcode-cn.com/1612446490-ClcHRD-%E5%89%91%E6%8C%87offer-06-%E4%BB%8E%E5%A4%B4%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A8%20\(1\).jpeg)


+ **那回溯是什么呢？**
在回调过程中，把之前正向调用的操作给撤销了。这样子就可以恢复到那个节点上的初始状态，还原现场。

```java
list.add(head.val); // 操作
recur(head.next);  // 递归调用
list.remove(list.size() - 1); // 撤销操作
```
![剑指offer-06-从头打印链表03.jpeg](https://pic.leetcode-cn.com/1612445925-lDgrho-%E5%89%91%E6%8C%87offer-06-%E4%BB%8E%E5%A4%B4%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A803.jpeg)

**这道题的递归解法**
```java
class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
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
}
```