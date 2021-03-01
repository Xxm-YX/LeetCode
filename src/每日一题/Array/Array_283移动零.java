package 每日一题.Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 */
public class Array_283移动零 {

    public static void moveZeroes(int[] nums) {
        if(nums.length == 0 ){
            return;
        }
        Deque<Integer> path = new LinkedList<>();

        for (int num : nums) {
            if(num != 0){
                path.offer(num);
            }
        }

        while(path.size() != nums.length){
            path.offerLast(0);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = path.pollFirst();
        }
    }

    public static void moveZeroes1(int[] nums) {
        if(nums == null){
            return;
        }
        
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0 就把其交换到左边，等于0的交换到右边
            if(nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        moveZeroes(a);

        for (int i : a) {
            System.out.println(i);
        }
    }
}
