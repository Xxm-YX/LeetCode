package 比赛;

import java.util.Arrays;

public class A_2早餐组合 {
    /**
     *
     * @param staple 主食价格
     * @param drinks 饮料价格
     * @param x 不超过的x元
     * @return
     */
    //双指针
    /*public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int mod = 1000000007;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int i = 0;
        int j = drinks.length - 1;
        long ans = 0;
        while(i < staple.length){
            while(j >= 0 && x < staple[i] + drinks[j]){
                j--;
            }
            ans += (j + 1) % mod;
            i++;
        }
        return (int)(ans % mod);
    }*/

    /**
     * 二分
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);

        int res = 0;

        int m = staple.length;
        for (int i  = 0; i< m ; i++) {
            int temp = x - staple[i];
            int local = binarySearch(drinks,temp);
            if(local == 0){
                break;
            }
            res = (res + local) % 1000000007;
        }
        return res;
    }

    private int binarySearch(int[] drinks, int temp) {
        //二分查找，查找到 右边部分，第一个 大于 temp的
        int i =0,j = drinks.length;
        while(i<j){
            int mid=i+(j-i)/2;
            if(drinks[mid]>temp){
                j = mid;
            }else{
                i = mid+1;
            }
        }
        return i;
    }

}

