package 每日一题.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class _18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

       List<List<Integer>> res = new ArrayList<>();
       if(nums == null || nums.length<4){
           return res;
       }

       Arrays.sort(nums);

       int length = nums.length;

       /*从这里开始，四个指针，k从0开始，i从k+1开始，留下jh，*/
       for(int k =0;k<length-3;k++){
           //去重
           if(k>0 && nums[k] == nums[k-1]){
               continue;
           }
            //当前最小值
           int min1 = nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
           if(min1 > target){
               break;
           }
           //当前最大值
           int max1 = nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
           if(max1 < target){
               continue;
           }

           //第二层循环
           for (int i = k+1; i <length-2 ; i++) {
                //去重
               if(i>k+1 && nums[i]==nums[i-1]){
                   //是k后面第二个开始
                   continue;
               }
               //指针j -> i+1
               int j = i+1;
               int h = length-1;

               int min2 = nums[k]+nums[i]+nums[j]+nums[j+1];
               if(min2 > target){
                   break;
               }
               int max2 = nums[k]+nums[i]+nums[h]+nums[h-1];
               if(max2 < target){
                   continue;
               }

               //开始j指针和h指针的表演
               while(j<h){
                   int curr=nums[k]+nums[i]+nums[j]+nums[h];
                   if(curr==target){
                       res.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                       j++;
                       //去重
                       while(j<h&&nums[j]==nums[j-1]) j++;
                       h--;
                       while(j<h&&nums[h]==nums[h-1]) h++;
                   }else if(curr > target){
                       h--;
                   }else if(curr < target){
                       j++;
                   }
               }
           }
       }
       return res;
        

    }
}
