package 每日一题.图;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 */
public class P_134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        //结果 编号
        int i = 0;
        while( i < n){
            int sumOfGas = 0,sumOfCost = 0;
            //cnt 为 走过的站点
            int cnt = 0;

            while(cnt < n){
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if( sumOfCost > sumOfGas){
                    //当消费大于 总量
                    break;
                }
                cnt++;
            }
            if(cnt == n){
                return i;
            }else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    /**
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare =Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if(spare < minSpare){
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1 )%len;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b= {3,4,5,1,2};
        canCompleteCircuit2(a,b);
    }
}
