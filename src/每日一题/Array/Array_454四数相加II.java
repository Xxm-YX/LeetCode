package 每日一题.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 */
public class Array_454四数相加II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();

        int res = 0;
        for (int i : A) {
            for (int j : B) {
                if(map.containsKey(i+j)) map.put(i+j,map.get(i+j)+1);
                else map.put(i+j,1);
            }
        }

        for (int i : C) {
            for (int j : D) {
                int sumCD = -(i+j);
                if(map.containsKey(sumCD)) res+=map.get(sumCD);
            }
        }
        return res;
    }
}
