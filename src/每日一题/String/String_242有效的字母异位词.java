package 每日一题.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class String_242有效的字母异位词 {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Integer> path = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            path.put(temp,path.getOrDefault(temp,0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if(path.containsKey(temp)){
                path.put(temp,path.get(temp)-1);
                if(path.get(temp) == 0){
                    path.remove(temp);
                }
            }else {
                return false;
            }
        }
        if(path.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length() || s == null || t == null) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[(int) (s.charAt(i) - 'a')]++;
            nums[(int) (t.charAt(i) - 'a')]--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram3(String s, String t) {
        if(s==""||t=="") return false;
        char[] schar=s.toCharArray();
        char[] tchar=t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar, tchar);
    }

        public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
