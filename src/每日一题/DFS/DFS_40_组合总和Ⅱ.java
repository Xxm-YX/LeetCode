package 每日一题.DFS;

import java.util.*;

/**
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class DFS_40_组合总和Ⅱ {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length =candidates.length;
        if(length == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates,target,res,path,0,length);

        return res;
    }

    public void dfs(int[] candidates,int target,List<List<Integer>> res,Deque<Integer> path,int begin,int length){

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }


        for(int i=begin;i<length;i++){
            //大剪枝
            if(target - candidates[i] < 0 ){
                return;
            }

            //小剪枝
            if(i>begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            target -= candidates[i];
            dfs(candidates,target,res,path,i+1,length);
            path.removeLast();
            target += candidates[i];
        }
    }
}
