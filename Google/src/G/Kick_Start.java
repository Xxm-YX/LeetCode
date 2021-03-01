package G;
import java.util.*;

public class Kick_Start {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            String str = sc.next();

            List<Integer> path = new ArrayList<>();

            int count = 0;
            int local_K = 0;
            while(local_K < str.length()){
                local_K = str.indexOf("KICK",local_K);
                if(local_K == -1){
                    break;
                }
                int local_S = local_K;
                while( local_S < str.length()){
                    local_S = str.indexOf("START",local_S);
                    if(local_S == -1){
                        break;
                    }
                    count++;
                    local_S++;
                }
                path.add(local_K);
                local_K++;
            }


            System.out.println("Case #"+(i+1)+": "+count);
        }
    }
}
