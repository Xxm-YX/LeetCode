package 每日一题.DP.股票问题;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class DP_122买卖股票的最佳时机2 {

    /**
     * DFS
     * @param prices
     * @return
     */
    private int res;
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        this.res = 0;
        dfs(prices,0,len,0,res);
        return this.res;
    }

    /**
     *
     * @param prices 股价数组
     * @param index 当前是第几天，从0 开始
     * @param status 0 代表不持有股票，1表示持有股票
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {

        if(index == len){
            this.res = Math.max(this.res,profit);
            return;
        }

        dfs(prices, index + 1 , len , status , profit);

        if(status == 0){
            //可以尝试转向1
            dfs(prices , index + 1,len , 1,profit - prices[index]);
        }else {
            //此时 status == 1 可以尝试 转向0
            dfs(prices , index + 1,len , 0 ,profit + prices[index]);
        }
    }

}
