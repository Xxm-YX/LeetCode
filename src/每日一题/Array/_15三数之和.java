package 每日一题.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class _15三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList();

        int len = nums.length;
        if(len == 0 || len<3) return res;

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if(nums[i]>0) break; //第一个数  如果大于0 后面的数肯定也大于零
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //这个地方第一个数已经处理了，从第二个数开始去重，避免第二个数跟第一个数相同

            int l = i + 1;
            int r = len - 1;
            while(l < r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l] == nums[l+1])l++;//最后到最后一个重复的地方下一个
                    while(l<r && nums[r] == nums[r-1])r--;
                    //几种情况，到中间还有 几个不重复的数
                    //到最后两个数已经交错了
                    //指针不必在意 它的值 越界了，就算到了最后一个 L = R, l+1; l=6,r=5, 说明后面的数都等于这个数，自动退出循环
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else if(sum > 0){
                    r--;
                }
            }
        }
        return res;
    }
}
