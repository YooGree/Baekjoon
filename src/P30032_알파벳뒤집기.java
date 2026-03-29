import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P30032_알파벳뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            String answer = "";
            String str = br.readLine();

            for (int j = 0; j < num; j++) {
                char ch = str.charAt(j);

                // 1은 상하방향
                if (direction == 1){
                    if (ch == 'd'){
                        answer += "q";
                    }else if (ch == 'b'){
                        answer += "p";
                    }else if(ch == 'q'){
                        answer += "d";
                    }else if (ch == 'p') {
                        answer += "b";
                    }
                    // 2는 좌우방향
                }else{
                    if (ch == 'd'){
                        answer += "b";
                    }else if (ch == 'b'){
                        answer += "d";
                    }else if(ch == 'q'){
                        answer += "p";
                    }else if (ch == 'p'){
                        answer += "q";
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
