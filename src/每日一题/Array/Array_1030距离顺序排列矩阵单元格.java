package 每日一题.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 *

 */
public class Array_1030距离顺序排列矩阵单元格 {

    /*
        直接排序
     */
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R*C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i,j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                //升序，两个节点的距离 算出来后进行 排序
                return (Math.abs(a[0] - r0)+Math.abs(a[1] - c0)
                           - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0)));
            }
        });
        return ret;
    }


    /*
        桶排序
     */
    public static int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        //求 整个范围内离 原点最远的距离
        int maxDist = Math.max(r0,R - 1 - r0) + Math.max(c0,C - 1 -c0);
        //桶
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //得到当前节点 离原点的距离
                int d = dist(i,j,r0,c0);
                bucket.get(d).add(new int[]{i,j});
            }
        }
        int[][] ret = new int[R*C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for(int[] it:bucket.get(i)){
                ret[index++] = it;
            }
        }
        return ret;
    }

    private static int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2 ) + Math.abs(c1 - c2);
    }


    /*
        几何法（类BFS）
     */

    /**
     *
     * @param R 行
     * @param C 列
     * @param r0 原点x
     * @param c0 原点y
     * @return
     */
    public static int[][] allCellsDistOrder2(int R, int C, int r0, int c0){
        int[][] re = new int[R*C][2];
        //设置原点
        re[0][0] = r0;
        re[0][1] = c0;
        int[] dr = {1,1,-1,-1};
        int[] dc = {1,-1,-1,1};
        int row = r0;
        int col = c0;
        int cnt = 1;
        while( cnt < R * C){
            row--;
            for (int i = 0; i < 4; i++) {
                //i 是 转圈的次数
                //边界问题
                while(
                        //这里是 i % 2 ==0   等于 左右两端
                       // 当到了同一行 就不能再右上角 或者 左下角找了 要开始改变方向了
                        (i % 2 == 0 && row != r0) ||
                        // i % 2 != 0  等于 上下
                        // 同理
                        (i % 2 != 0 && col != c0)){
                    if(row >= 0 && row < R && col >= 0 && col < C){
                        re[cnt++] = new int[]{row,col};
                    }
                    //开始转圈
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        allCellsDistOrder2(2,3,0,0);
    }
}
