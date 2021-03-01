package 剑指Offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 */
public class O04二维数组中的查找 {

    /**
     * 暴力
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length,col = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {

                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 线性 从右上角开始
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length,col = matrix[0].length;
        int r = 0, c = col-1;
        while(r < rows && c >= 0){
            int num = matrix[r][c];
            if(num == target){
                return true;
            }else if(num > target){
                c--;
            }else {
                r++;
            }
        }
        return false;
    }
}
