package 每日一题.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 *

 */
public class String_205_同构字符串 {

    /**
     * 方法一：双哈希表对应
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char x = s.charAt(i),y = t.charAt(i);

            if((s2t.containsKey(x) && s2t.get(x) != y) || t2s.containsKey(y) && t2s.get(y) != x){
                return false;
            }

            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }

    /**
     * 方法二：双数组
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                return false;
            }
            preIndexOfs[chars[i]] = i + 1;
            preIndexOft[chart[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        isIsomorphic2("egg","add");
    }
}
