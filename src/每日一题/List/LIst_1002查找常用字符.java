package 每日一题.List;

import java.util.*;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *  
 *示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *

 */
public class LIst_1002查找常用字符 {

    public List<String> commonChars(String[] A) {
        if(A.length == 0){
            return new ArrayList<>();
        }

        //建立计数数组
        int[] path = new int[26];
        Arrays.fill(path,Integer.MAX_VALUE);

        for (String word : A) {
            int[] temp = new int[26];
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                temp[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                path[i] = Math.min(path[i],temp[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < path[i]; j++) {
                res.add(String.valueOf((char)(i + 'a')));
            }
        }
        return res;

    }
}
