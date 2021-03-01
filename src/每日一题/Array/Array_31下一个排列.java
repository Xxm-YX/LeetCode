package 每日一题.Array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class Array_31下一个排列 {

    /**
     * 官方解法：两次遍历，找小数  和 找大数
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while( i >= 0 && nums[i] >= nums[i + 1]){
            //从后向前 找 当前元素 小于 后面一个元素
            i--;
        }
        if(i >= 0){
            //找到了
            int j = nums.length - 1;
            //再从后往前找，找 第一个 j 比 i 大的数
            while( j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i , j);
        }
        reverse(nums , i + 1);

    }

    //交换
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //逆序
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation1(int[] nums) {
        //数组长度
        int len = nums.length;
        //i从最后一个开始
        for (int i = len - 1; i > 0 ; i--) {
            if(nums[i] > nums[i - 1]){
                //当前i 在 找 第一个相邻逆序 的数 i-1 i  要改变i-1
                //找到了 前一个 比 后面一个 要大的数
                //从i，到 len-1 元素的 正序排列
                Arrays.sort(nums,i,len);
                for (int j = i ; j < len ; j++){
                    if(nums[j] > nums[i - 1]){
                        if(nums[j] > nums[i - 1]){
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            return;
                        }
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;


    }
}
