package 每日一题.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Array_349两个数组的交集 {

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        int i = 0 , j = 0 , len1 = nums1.length,len2 = nums2.length;
        Set<Integer> res = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i < len1 && j < len2){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] res1 = new int[res.size()];
        int c = 0;
        Iterator<Integer> it = res.iterator();
        while(it.hasNext()){
            res1[c] = it.next();
            c++;
        }
        return res1;
    }

    /**
     *二分查找吧
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int target : nums1) {
            if(binarySearch(nums2,target) && !set.contains(target)){
                set.add(target);
            }
        }
        int index = 0;
        int[] res = new int[set.size()];
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }

    private static boolean binarySearch(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = (left+right+1)>>1;
            if(nums[mid] == target){
                return true;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {4,9,5};
        int[] b = {9,4,9,8,4};
        System.out.println(intersection(a,b));
    }
}
