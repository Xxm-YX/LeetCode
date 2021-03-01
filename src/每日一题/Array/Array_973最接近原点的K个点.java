package 每日一题.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 */
public class Array_973最接近原点的K个点 {

    /**
     * 排序
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest1(int[][] points, int K) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {

                return (point1[0] * point1[0] +
                        point1[1] * point1[1]) -
                        (point2[0] * point2[0] +
                         point2[1] * point2[1])
                ;
            }
        });
        return Arrays.copyOfRange(points , 0 ,K);
    }

    /**
     * 优先队列
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        //优先队列，可以自己设置插入的规则（顺序，逆序）
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
                /*
                    原本顺序
                        y2 y1 ....

                 */
            }
        });

        for (int i = 0; i < K; i++) {
            //
            pq.offer(new int[]{points[i][0] * points[i][0] +
                               points[i][1] * points[i][1]});
        }

        int n = points.length;

        for (int i = K; i < n; i++) {
            int dist = points[i][0] * points[i][0] +
                       points[i][1] * points[i][1];
            if(dist < pq.peek()[0]){
                pq.poll();
                pq.offer(new int[]{dist,i});
            }
        }
        return null;
    }

}
