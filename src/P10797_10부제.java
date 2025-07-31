import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10797_10부제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == N) cnt++;
        }

        System.out.println(cnt);
    }
}
