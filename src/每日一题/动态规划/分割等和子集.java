package 每日一题.动态规划;

public class 分割等和子集 {

    /**
     * 方法一
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        //判断：奇数 就不符合要求
        if((sum&1) == 1){
            return false;
        }

        int target = sum / 2;
        //创建二维数组，行：物品，列：背包容量
        boolean[][] dp = new boolean[len][target+1];

        //先 填第一个物品 就是第一行,因为只有一个物品，所以只能是刚好装满的那个是位置
        //dp[0][] 第一个物品
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        //再填下面的行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                //先把上面的结果抄下来
                dp[i][j] = dp[i - 1][j];

                if(nums[i] == j){
                    //如果 物品i 刚好等于 容量 可以刚好装满
                    dp[i][j] = true;
                    continue;
                }

                if(nums[i] < j){
                   /*
                      如果 背包容量 大于 当前物品的重量
                      两个选择：
                          1、不选择这个物品，说明 在这个物品之前，就已经可以装满，dp[i-1][j]
                          2、选择这个物品，说明 当加上这个物品后 刚好可以装满，d[i-1][j-num[i]]
                    */

                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }

    /**
     * 优化一
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];

        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
        dp[0][0] = true;

        if (nums[0] == target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }

            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }

    /**
     * 优化二
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        //奇数
        if((sum&1) == 1){
            return false;
        }

        int target = sum /2;

        //一维数组
        boolean[] dp = new boolean[target + 1];

        //第一个 取true;
        dp[0] = true;

        if(nums[0] <= target){
            dp[nums[0]] = true;
        }

        for(int i = 1;i < len ;i++){
            for (int j = target ; nums[i] <= target ; j++) {
                //因为 当 nums[i]比target还要大的时候，往后只会越来越小
                if(dp[target]){
                    return true;
                }

                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
