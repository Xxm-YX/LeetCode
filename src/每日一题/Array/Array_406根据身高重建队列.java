package 每日一题.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 */
public class Array_406根据身高重建队列 {

    /**
     * 从低到高考虑
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if(person1[0] != person2[0]){
                    //如果 身高不相等 按照身高升序排列
                    return person1[0] - person2[0];
                }else {
                    //如果 身高相等，按照 前面高度的人数 降序排列
                    return person2[1] - person1[1];
                }
            }
        });

        /*
            上面排序后的结果
                   [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
                    4,4     5,2    5,0    6,1    7,1    7,0

         */
        int n = people.length;
        //结果集
        int[][] ans = new int[n][];
        for (int[] person : people) {
            //前面 大于等于人的个数
            int spaces = person[1] + 1;
            for (int i = 0; i < n; i++) {
                if(ans[i] == null){
                    --spaces;
                    if(spaces == 0){
                        //等于0 说明就是当前位置
                        ans[i] = person;
                        break;
                    }
                }
            }
            /*
            上面排序后的结果
                    4,4     5,2    5,0    6,1    7,1    7,0
                    5,0     7,0  5,2      6,1    4,4     7,1


         */
        }
        return ans;
    }

    /**
     * 从高到低考虑
     * @param people
     * @return
     */
    public static int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if(person1[0] != person2[0]){
                    return person2[0] - person1[0];
                }else {
                    return person1[1] - person2[1];
                }
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            // a.add(index,element);
            ans.add(person[1],person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {
                {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };

        reconstructQueue(a);
    }
}
