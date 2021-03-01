package 每日一题.Array;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Array_977有序数组的平方 {

    /**
     * 方法一：暴力
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length;i++){
            A[i]= A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 方法二：双指针
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    /**
     * 方法三：
     * 双指针：归并 + 二分查找
     * @param A
     * @return
     */
    public int[] sortedSquares3(int[] A) {

        int n = A.length;
        int neg = binerySearch(A); //查找第一个负数的下标

        int[] res = new int[n];

        int index = 0,i = neg,j = neg+1;

        while(i>=0 || j<n){
            if( i < 0){
                res[index] = A[j]*A[j];
                j++;
            }else if(j == n){
                res[index] = A[i]*A[i];
                i--;
            }else if(A[i]*A[i] > A[j]*A[j]){
                res[index] = A[j]*A[j];

                j++;
            }else {
                res[index] = A[i]*A[i];
                i--;
            }
            index++;
        }
        return res;
    }
    //        二分查找
    public int binerySearch(int[] A){
        int i =0;
        int n = A.length;
        int j = n - 1;

        while(i < j){
            int mid = i+j>>1;
            if(A[mid] >=0 && A[j]>=0){
                j = mid;
            }else if(A[mid] < 0 && A[i] < 0){
                i = mid;
            }
            if(i + 1 == j) {
                break;
            }
        }
        return i;
    }
}
