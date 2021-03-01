package 每日一题.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 */
public class Array_1365有多少小于当前数字的数字 {

    /**
     * 暴力
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length ;i++) {
            int curr = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(i == j){
                    continue;
                }
                if(nums[i] > nums[j]){
                    res[i]++;
                }
            }
        }
        return res;
    }

    /**
     * 快排
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {

        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });

        int[] res = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if(prev == -1 || data[i][0] != data[i-1][0]){
                //这个地方，好好理解，prev 是 前面的个数，data[i][0] != data[i-1][0]是前后不相等
                //因为第一个 前面没有小的，就是0，后面的就是i，
                prev = i;
            }
            res[data[i][1]] =prev;
        }
        return res;
    }

    /**
     * 计数排序
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] cnt = new int[101];//值域
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //每个元素的个数
            cnt[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i-1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i] == 0?0:cnt[nums[i]-1];
        }
        return res;
    }
}
