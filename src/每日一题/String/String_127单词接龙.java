package 每日一题.String;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 */
public class String_127单词接龙 {

    /**
     * BFS 广度优先遍历
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1、将所有字符串都存到哈希表中，判断某个单词是否在wordList中
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }

        wordSet.remove(beginWord);

        //2.图的广度优先遍历，必须使用队列，已经访问过的visited哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //3.开始广度遍历，包含起点，
        int step = 1;
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                //依次遍历当前队列中的单词
                String currentWord = queue.poll();

                //如果currentWord 能够修改1个字符与 endWord相同，则返回step+1

                if(changeWordEveryOneLetter(currentWord,endWord,queue,visited,wordSet)){
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     */
    private static boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {

        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            //先保存，后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k < 'z'; k++) {
                //这里开始 尝试每一个字母，
                if(k == originChar){
                    continue;
                }

                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                //首先看当前这个字符串，是否包含在集合总
                if(wordSet.contains(nextWord)){
                    //在集合中，判断当前字符串 是否 是这个最后的字符串
                    if(nextWord.equals(endWord)){
                        return true;
                    }

                    if(!visited.contains(nextWord)){
                        queue.add(nextWord);
                        //注意：添加到队列以后，必须马上标记已经访问
                        visited.add(nextWord);
                    }
                }
            }
            //恢复
            charArray[i] = originChar;
        }
        return false;
    }


    /**
     * 优化 双向BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //1.放到hash表中，便于判断
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }

        //2.已经访问过的word添加到visited哈希表
        Set<String> visited = new HashSet<>();
        //分别用左边和右边扩散 的哈希表代替单向 BFS队列，在双向BFS的过程中交替使用
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        //3.执行双向BFS，左右交替扩散的步数之和为所求
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()){
            //优先选小的哈希表进行扩散，考虑到的情况更少
            if(beginVisited.size() > endVisited.size()){
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            //保证beginVisited是相对较小的集合，nextLevelVisited
            //在扩散完成后，会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if(changeWordEveryOneLetter2(word,endVisited,visited,wordSet,nextLevelVisited)){
                    return step + 1;
                }
            }

            //原来的beginVisited废弃，从nextLevelVisited开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    private boolean changeWordEveryOneLetter2(String word,
                                              Set<String> endVisited,
                                              Set<String> visited,
                                              Set<String> wordSet,
                                              Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if(originChar == c){
                    continue;
                }
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord)){
                    if(endVisited.contains(nextWord)){
                        return true;
                    }
                    if(!visited.contains(nextWord)){
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            //恢复，下次使用
            charArray[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        List<String> c = new ArrayList<>();
        c.add("hot");
        c.add("dot");
        c.add("dog");
        c.add("lot");
        c.add("log");
        c.add("cog");
        ladderLength(a,b,c);
    }
}
