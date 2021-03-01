package 每日一题.String;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 */
public class String_139单词拆分 {

    /**
     * 使用API
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] memo = new boolean[n+1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //listAPI，contains（string）
                //substring（j,i）第i位
                if(memo[j] && wordDict.contains(s.substring(j,i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }


    /**
     * DFS
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak1(String s, List<String> wordDict) {
        //记录 当前位置开始 是含有当前 单词的
        boolean[] path = new boolean[s.length()+1];
        return dfs(s,0,wordDict,path);
    }

    private static boolean dfs(String s, int start, List<String> wordDict, boolean[] path) {
        for (String word : wordDict) {
            //下一次开始的位置
            int nextStart = start + word.length();

            if(nextStart > s.length() || path[nextStart]){
                //如果当前开始的位置比整个字符串都大||当前位置已经记录是true
                continue;
            }

            if(s.indexOf(word,start) == start){
                if(nextStart == s.length() || dfs(s,nextStart,wordDict,path)){
                    return true;
                }
                path[nextStart] = true;
            }
        }
        return false;

    }

    /**
     * BFS
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {
        Queue<Integer> path = new LinkedList<>();
        path.add(0);

        int slength = s.length();
        boolean[] visited = new boolean[slength + 1];

        while(!path.isEmpty()){
            int size = path.size();
            for (int i = 0; i < size; i++) {
                int start = path.poll().intValue();
                //
                for (String word : wordDict) {
                    int nextStart = start + word.length();
                    if(nextStart > slength || visited[nextStart]){
                        //开始结点 大于 总长度
                        //
                        continue;
                    }

                    if(s.indexOf(word,start) == start){
                        if(nextStart == slength){
                            //刚好到了最后一个位置
                            return true;
                        }

                        path.add(nextStart);
                        visited[nextStart] = true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * DP(官方题解)
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1 ; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    //因为要连起来，所以 前面的可以判断后面的是否符合
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * DP优化
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak4(String s, List<String> wordDict) {
        //字典中 字符串的最大长度
        int maxWordLength = 0;
        Set<String> wordSet = new HashSet<>(wordDict.size());
        for (String word : wordDict) {
            wordSet.add(word);

            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = (i - maxWordLength < 0 ? 0 : i - maxWordLength); j < i; j++) {
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
//        String a = "catsandog";
//        List<String> b = new ArrayList<>();
//        b.add("cats");
//        b.add("dog");
//        b.add("sand");
//        b.add("and");
//        b.add("cat");

        String a = "leetcode";
        List<String> b = new ArrayList<>();
        b.add("leet");
        b.add("code");
        wordBreak4(a,b);
    }
}
