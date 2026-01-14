import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2999_비밀이메일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] msg = br.readLine().toCharArray();
        int R = 0;
        int C = 0;
        for (int i = 1; i < (int)Math.sqrt(msg.length)+1; i++) {
            if(msg.length%i == 0) {
                R = i;
                C = msg.length/i;
            }
        }
        char[][] sec = new char[R][C];
        int count = 0;
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                sec[i][j] = msg[count++];
            }
        }
        for (char[] is : sec) {
            for (char a : is) {
                System.out.print(a);
            }
        }
    }

}
