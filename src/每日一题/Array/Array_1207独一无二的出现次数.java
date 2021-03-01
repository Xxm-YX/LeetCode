package 每日一题.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 */
public class Array_1207独一无二的出现次数 {

    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length == 0){
            return true;
        }

        Map<Integer,Integer> res = new HashMap<Integer,Integer>();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int count = 1;
            if(res.containsValue(arr[i])){
                continue;
            }
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(res.containsKey(count)){
                return false;
            }
            res.put(count,arr[i]);
        }
        return true;
    }

    /**
     * 官方题解
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }


}
