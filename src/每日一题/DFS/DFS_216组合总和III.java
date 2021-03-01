package 每日一题.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class DFS_216组合总和III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();

        dfs(k,n,1,res,path);

        return res;
    }

    public void dfs(int k,int n,int begin,List<List<Integer>> res,Deque<Integer> path){
        if(n <= 0 || path.size()==k){
            if(n==0 && path.size() == k){
                res.add(new ArrayList<>(path));
            }
            return;
        }


        for (int i = begin; i <= 9; i++) {
            //大剪枝
            if(n-i < 0){
                return;
            }

            path.addLast(i);
            dfs(k,n-i,i+1,res,path);
            path.removeLast();
        }



      /*  List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();*/

        /*public List<List<Integer>> combinationSum3(int k, int n) {
            for (int mask = 0; mask < (1 << 9); ++mask) {
                if (check(mask, k, n)) {
                    ans.add(new ArrayList<Integer>(temp));
                }
            }
            return ans;
        }

        public boolean check(int mask, int k, int n) {
            temp.clear();
            for (int i = 0; i < 9; ++i) {
                if (((1 << i) & mask) != 0) {
                    temp.add(i + 1);
                }
            }
            if (temp.size() != k) {
                return false;
            }
            int sum = 0;
            for (int num : temp) {
                sum += num;
            }
            return sum == n;
*/
    }
}
