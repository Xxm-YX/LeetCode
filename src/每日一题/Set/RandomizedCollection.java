package 每日一题.Set;

import java.util.*;

public class RandomizedCollection {

    Map<Integer, Set<Integer>> idx;//map 集合 存放（插入的数据，集合（存放的是插入的数据在链表中的位置））
    List<Integer> nums;//链表 存放的是插入的数据

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        //
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        System.out.println(idx.get(val));
        //得到set集合
        Iterator<Integer> it = idx.get(val).iterator();

        int i = it.next();
        //得到当前链表最后一个元素
        int lastNum = nums.get(nums.size() - 1);
        //替换链表中 i 位置的元素
        nums.set(i, lastNum);
        //得到val那个set集合然后 删除 i
        idx.get(val).remove(i);
        //得到最后那个元素的 set集合 删除 链表长度减一 的那个元素
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
