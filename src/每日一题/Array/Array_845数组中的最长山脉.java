package 每日一题.Array;
/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 */
public class Array_845数组中的最长山脉 {

    /**
     * 动态规划   从山顶 向两遍递推
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组 AA 的长度。
     *
     * 空间复杂度：O(n)O(n)，数组所需空间
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        int n = A.length;
        if(n == 0){
            return 0;
        }

        //左边记录
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }


        int[] right = new int[n];
        for (int i = n-2; i >= 0; --i) {
            right[i] = A[i+1] < A[i] ? right[i+1]+1:0;
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            if(left[i] > 0 && right[i] > 0){
                res = Math.max(res,left[i]+right[i]+1);
            }
        }
        return res;
    }

    /**
     * 枚举山脚
     时间复杂度：O(n)O(n)，其中 nn 是数组 AA 的长度。

     空间复杂度：O(1)O(1)。
     *
     */
    public int longestMountain2(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while(left + 2 < n){
            int right = left +1;
            if(A[left] < A[left + 1]){
                //爬坡
                //当前left是爬坡起点
                while(right + 1 < n && A[right] < A[right + 1]){
                    //这也是在爬坡
                    ++right;
                }
                if(right < n-1 && A[right] > A[right + 1]){
                    //开始下坡
                    while(right + 1 < n && A[right] > A[right+1]){
                        ++right;
                    }
                    //到这里，right就是下坡终点
                    ans = Math.max(ans,right - left +1);
                }else {
                    ++right;
                }
            }
            //如果不满足爬坡要求，left起点右移一位
            left = right;
        }
        return ans;
    }

    /**
     * 目前看到最简洁的 枚举山顶
     */
    public int longestMountain3(int[] A) {
        int ans = 2;
        int n = A.length;
        for (int i = 1; i < n-1; i++) {
            //先找到山峰
            if(A[i] > A[i-1] && A[i]>A[i+1]){
                int j = i-1;
                int k = i+1;
                while(j>=0 && A[j]<A[j+1]){j--;}
                while(k<n && A[k]<A[k-1]){k++;}

                ans = Math.max(ans,k - j - 1);
            }
        }
        return ans==2 ? 0 : ans;
    }
}
