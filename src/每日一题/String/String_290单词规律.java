package 每日一题.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 */
public class String_290单词规律 {

    public boolean wordPattern(String pattern, String str) {
        Map<String,Character> str2ch = new HashMap<>();
        Map<Character,String> ch2str = new HashMap<>();

        int m = str.length();//匹配的长度
        int i = 0;//记录每一块字符串的开头
        for (int p = 0; p < pattern.length(); p++) {
            //记录当前对应的规则
            char ch = pattern.charAt(p);

            if(i >= m){
                return false;
            }

            int j = i ;
            while(j < m && str.charAt(j) != ' '){
                j++;
            }

            String tmp = str.substring(i,j);
            if(str2ch.containsKey(tmp) && str2ch.get(tmp) != ch){
                return false;
            }

            if(ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))){
                return false;
            }

            str2ch.put(tmp,ch);
            ch2str.put(ch,tmp);
            i = j + 1;
        }
        return i >= m;
    }
}
