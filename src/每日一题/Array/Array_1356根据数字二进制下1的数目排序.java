package 每日一题.Array;

import java.util.*;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 */
public class Array_1356根据数字二进制下1的数目排序 {

    public static int[] sortByBits(int[] arr) {
        //记录当前数 1的个数
        int[] bit = new int[10001];

        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }

        Collections.sort(list,new Comparator<Integer>(){

            @Override
            public int compare(Integer x, Integer y) {
                if(bit[x] != bit[y]){
                    //y是前面的数，x是后面的数
                    //bit[x] - bit[y]
                    /*
                        这个地方要画个图   1 2 3 4 5 6 7 list
                                      0 1 2 3 4 5 6 7 bit  这里的数就是位置
                                      0 1 1 2 1 2 2 3
                     */
                    return bit[x] - bit[y];
                }else {
                    //这里是 bit[x] = bit[y] 说明他们的1是相等的，按照本身位置来排序就行
                    // x 是后面的数 比 y 大，正序  x - y > 0  y x...
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int get(int x){
        int res = 0;
        while(x != 0){
            res += x % 2;
            x /= 2;
        }
        //返回当前数 1的个数
        return res;
    }

    public static int[] sortByBits2(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
        }
        int[] bit = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int[] sortByBits3(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;
        }
        return map;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        sortByBits3(a);
    }
}
