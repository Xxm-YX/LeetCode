package 每日一题.Array;

import java.util.Arrays;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 */
public class Array_1024视频拼接 {

    /**
     * 动态规划
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);

        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                //判断点，给出的区间要包含 当前的区间  aj< i <= bj
                if(clip[0] < i && i <= clip[1]){
                    dp[i] = Math.min(dp[i],dp[clip[0]]+1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE-1 ? -1 : dp[T];

    }

    /**
     * 贪心算法
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching2(int[][] clips, int T) {
        int[] maxn = new int[T];

        int pre = 0 , res = 0 , last = 0;
        for (int[] clip : clips) {
            if(clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }

        for (int i = 0; i < T; i++) {
            last = Math.max(last,maxn[i]);

            if(last == i){
                return -1;
            }

            if(pre == i){
                res++;
                pre = last;
            }
        }
        return res;
    }

}
