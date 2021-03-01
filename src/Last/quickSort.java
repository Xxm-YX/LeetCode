package Last;

import java.util.Scanner;

/**
 * 老快排了
 */

public class quickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] q = new int[sc.nextInt()];

        for (int i = 0; i < q.length; i++) {

            q[i] = sc.nextInt();
        }

        quick_sort(q,0,q.length-1);

        for (int i : q) {
            System.out.println(i);
        }
    }

    private static void quick_sort(int[] q, int l, int r) {
      //递归出口
        if(l >= r){
            //这个地方 等于说明不需要再交换了
            return;
        }
        int i = l-1,j = r+1, mid = q[i+j+1>>1];
        while(i<j){
            do i++;while(q[i]<mid);
            do j--;while(q[j]>mid);
            if( i < j){
                //说明还在两边
                swap(q,i,j);
            }
        }
        quick_sort(q,l,i-1);
        quick_sort(q,i,r);
    }

    private static void swap(int[] q,int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }


}
