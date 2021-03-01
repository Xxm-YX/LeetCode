package 每日一题.Array;

import java.util.Deque;
import java.util.LinkedList;

/**
  给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

  注意:

  num 的长度小于 10002 且 ≥ k。
  num 不会包含任何前导零。
  示例 1 :

  输入: num = "1432219", k = 3
  输出: "1219"
  解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
  示例 2 :

  输入: num = "10200", k = 1
  输出: "200"
  解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
  示例 3 :

  输入: num = "10", k = 2
  输出: "0"
  解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class Array_402移掉K位数字 {

    public String removeKdigits(String num, int k) {
        Deque<Character> path = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while(!path.isEmpty() && k > 0 && path.peekLast() > digit){
                //出现 单调下降了，不太好搞了
                path.pollLast();
                k--;
            }
            path.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            //特殊情况，如果一直单调递增，从最后一个开始去除
            path.pollLast();
        }

        StringBuffer ret = new StringBuffer();
        boolean leadingZero = true;
        while(!path.isEmpty()){
            char digit = path.poll();
            if(leadingZero && digit == '0'){
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();

    }
}
