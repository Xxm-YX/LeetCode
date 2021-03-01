package 每日一题.String;

public class String_844比较含退格的字符串 {

    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb_S = new StringBuilder();
        StringBuilder sb_T = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {

            if(S.charAt(i)=='#'){
               deletc(sb_S);
                continue;
            }
            sb_S.append(S.charAt(i));
        }

        for (int i = 0; i < T.length(); i++) {

            if(T.charAt(i)=='#'){
                deletc(sb_T);
                continue;
            }
            sb_T.append(T.charAt(i));
        }

        return (sb_S.toString()).equals(sb_T.toString());
    }

    public void deletc(StringBuilder Q){
        if(Q.length()!=0){
            Q.deleteCharAt(Q.length()-1);
        }
    }


}
