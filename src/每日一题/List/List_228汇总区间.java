package 每日一题.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 */
public class List_228汇总区间 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int i =0;
        int n = nums.length;

        while(i < n){
            int low = i;
            i++;
            while(i < n && nums[i] == nums[i - 1] + 1){
                i++;
            }

            int high = i - 1 ;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if( low < high){
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            res.add(temp.toString());
        }
        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return list;
    }
}
