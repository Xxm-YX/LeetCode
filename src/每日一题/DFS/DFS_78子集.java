package 每日一题.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class DFS_78子集 {
    /**
     * DFS
     * @param nums
     * @return
     */
    /*public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,res,nums,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int begin,List<List<Integer>> res, int[] nums, ArrayList<Integer> temp) {
        res.add(temp);
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(i+1,res,nums,temp);
            temp.remove(temp.size()-1);
        }
    }*/

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    /**
     * 迭代
     * @param nums
     * @return
     */
   /* public List<List<Integer>> subsets(int[] nums){
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        int n = nums.length;
        res.add(new ArrayList<Integer>());
        for (int mask = 1; mask < (1<<n); mask++) {
            tmp.clear();
            for (int i = 0; i < n; i++) {
                if((mask & (1<<i)) != 0){
                    tmp.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }*/
}
