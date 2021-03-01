package 每日一题.Array;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Array_75颜色分类 {

/*

    public void sortColors(int[] nums) {
        int a,b,c;
        a=0;
        b=0;
        c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                a++;
            }else if(nums[i]==1){
                b++;
            }else{
                c++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(a!=0){
                a--;
                nums[i]=0;
            }else if(b!=0){
                b--;
                nums[i]=1;
            }else{
                c--;
                nums[i]=2;
            }
        }

//        nums =  res.stream().mapToInt(Integer::intValue).toArray().clone();
    }
    */

    /**
     * 方法 一（），单指针 双循环
     *
     *      循环一：碰到0 就 交换
     *      循环二：碰到1 就 交换
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }

        for (int i = ptr; i < n; i++) {
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    /**
     * 方法二：双指针 单循环
     *      两个指针  p0,p1
     *      每次碰到 1 跟 p1 交换，然后 p1前进一格
     *      每次碰到 0 跟 p0 交换，然后 派单
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int length = nums.length;

        int p0 =0,p1 = 0;
        for(int i =0;i<length ;i++){
            if(nums[i] == 1){
                //p1每次交换 本身都不是1 都是2
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }else if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0 < p1){
                    /*
                        说明 现在p0 在p1前面
                        p1前面都是已经排好的1
                        这个时候 p0肯定指向 1
                        刚刚的绝壁 把 1 给交换出去了，现在 p1 指向的 肯定是2  将p1,i再交换，
                        */
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                //每次交换 完0，两个指针都要++，因为 0 是最左边的区间
                p1++;
                p0++;
            }
        }
    }

    /**
     * 方法三：
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int length = nums.length;

        int p0 = 0 , p2 = length-1;

        for (int i = 0; i <= p2; i++) {
            while(i<=p2 && nums[i] == 2){
                //避免 p2 也是 2 的情况，交换回去后 nums[i]指向的还是2
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }

            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }

}
