package 每日一题.String;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 */
public class String_925长按键入 {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0 , j = 0;
        int n = name.length();
        int t = typed.length();

        if(name.charAt(0) != typed.charAt(0)){
            return false;
        }


        while(i < n || j < t){
            if(j >= t){
                return false;
            }
            if(i >= n && j < t){
                while(true){
                    if(typed.charAt(j) != name.charAt(i-1)){
                        return false;
                    }
                    if(j == t -1){
                        break;
                    }
                    j++;
                }
                return true;

            }
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if(i >= 1 && typed.charAt(j) == name.charAt(i-1)){
                return false;
            }else {
                j++;
            }


        }
        return true;
    }
}
