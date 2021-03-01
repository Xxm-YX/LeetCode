package 每日一题.Array;

import java.util.*;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 */
public class Array_1122数组的相对排序 {

    /**
     * 计数排序
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper,x);
        }

        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            //记录每个数在数组中的数量
            ++frequency[x];
        }

        //结果数组
        int[] res = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; i++) {
                res[index++] = x;
                //一个一个的填入
            }
            frequency[x] = 0;
        }

        for (int x = 0; x <= upper; x++) {
            for (int i = 0; i < frequency[x]; i++) {
                res[index++] = x;
            }
        }
        return res;
    }


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],i);
        }
        Collections.sort(list,(x,y) ->{
            if(map.containsKey(x) || map.containsKey(y)){
                return map.getOrDefault(x,1001) - map.getOrDefault(y,1001);
            }
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,3,2,4,6,7,9,2,19};
        int[] b = {2,1,4,3,9,6};

        relativeSortArray(a,b);
    }
}
